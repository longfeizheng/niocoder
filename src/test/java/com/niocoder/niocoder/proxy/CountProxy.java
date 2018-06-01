package com.niocoder.niocoder.proxy;

import com.niocoder.niocoder.proxy.impl.CountImpl;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class CountProxy implements Count {

    private CountImpl countImpl;

    public CountProxy(CountImpl count) {
        this.countImpl = count;
    }

    @Override
    public void queryCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImpl.queryCount();
        System.out.println("事务处理之后");
    }

    @Override
    public void updateCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImpl.queryCount();
        System.out.println("事务处理之后");
    }
}
