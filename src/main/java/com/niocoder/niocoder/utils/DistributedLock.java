package com.niocoder.niocoder.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created on 2018/6/3.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class DistributedLock {

    private CuratorFramework client = null;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用于挂起当前请求，并且等到上一个分布式锁释放
    private static CountDownLatch zkLockLatch = new CountDownLatch(1);

    //分布式锁的总节点名
    private static final String ZK_LOCK_PROJECT = "nio-lock";

    //分布式锁节点
    private static final String DISTRIBUTED_LOCK = "distributed_lock_order";

    public DistributedLock(CuratorFramework client){
        this.client = client;
    }

    /**
     * 初始化锁
     */
    public void init(){
        //使用命名空间
        client = client.usingNamespace("ZKLocks-Namespace");

        //创建zk的总结点，
        /**
         * ZKLocks-Namespace
         *     |
         *      ---nio-lock
         *            |
         *              ----distributed_lock_order
         */

        try{
            if(client.checkExists().forPath("/"+ZK_LOCK_PROJECT) == null){
                client.create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                        .forPath("/"+ZK_LOCK_PROJECT)
                        ;
            }
            //针对分布式锁节点，创建相应的watcher事件监听
            addWatcherToLock("/"+ZK_LOCK_PROJECT);

        }catch (Exception e){
            logger.error("客户端连接zookeeper服务器错误....请重试");
        }finally {

        }
    }

    private void addWatcherToLock(String path) throws Exception {
        final PathChildrenCache cache = new PathChildrenCache(client,path,true);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)){
                    String path =event.getData().getPath();
                    logger.info("上一个会话已经释放或该会话已断开，节点路径为："+path);
                    if(path.contains(DISTRIBUTED_LOCK)){
                        logger.info("释放计数器，让当前请求来获得分布式锁。。。");
                        zkLockLatch.countDown();
                    }
                }
            }
        });
    }

    public boolean releaseLock(){
        try{
            if(client.checkExists().forPath("/"+ZK_LOCK_PROJECT+"/"+DISTRIBUTED_LOCK)!=null){
                client.delete().forPath("/"+ZK_LOCK_PROJECT+"/"+DISTRIBUTED_LOCK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        logger.info("分布式锁释放完毕");
        return true;
    }

    /**
     * 创建watcher监听
     */
    public void getLock(){
        while (true){
            try{
                client.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)//临时节点 会话失效后自动删除
                    .forPath("/"+ZK_LOCK_PROJECT+"/"+DISTRIBUTED_LOCK);
                logger.info("获取分布式锁成功");
            }catch (Exception e){
                logger.error("获取分布式锁失败。。。");
                try{
                    //如果没有获取到锁，需要重新设置同步资源值
                    if(zkLockLatch.getCount()==0){
                        zkLockLatch = new CountDownLatch(1);
                    }
                    //阻塞线程
                    zkLockLatch.await();
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
}
