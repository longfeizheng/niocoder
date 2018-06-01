package com.niocoder.niocoder.proxy;

import com.niocoder.niocoder.proxy.impl.CountImpl;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class TestCount {
    public static void main(String[] args) {
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.queryCount();
        countProxy.updateCount();
    }
}
