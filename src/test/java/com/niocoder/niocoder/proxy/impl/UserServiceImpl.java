package com.niocoder.niocoder.proxy.impl;

import com.niocoder.niocoder.proxy.UserService;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("-----------add------------");
    }
}
