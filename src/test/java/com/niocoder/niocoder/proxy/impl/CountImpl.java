package com.niocoder.niocoder.proxy.impl;

import com.niocoder.niocoder.proxy.Count;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("查看账户");
    }

    @Override
    public void updateCount() {
        System.out.println("更新账户");
    }
}
