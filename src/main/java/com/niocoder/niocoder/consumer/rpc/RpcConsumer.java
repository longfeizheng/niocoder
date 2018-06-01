package com.niocoder.niocoder.consumer.rpc;

import java.lang.reflect.Proxy;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class RpcConsumer {
    public static <T> T getService(Class<T> clazz,String ip,int port) {
        ProxyHandler proxyHandler =new ProxyHandler(ip,port);
        return (T) Proxy.newProxyInstance(RpcConsumer.class.getClassLoader(), new Class<?>[] {clazz}, proxyHandler);
    }
}
