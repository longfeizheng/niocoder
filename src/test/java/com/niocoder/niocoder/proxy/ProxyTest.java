package com.niocoder.niocoder.proxy;

import com.niocoder.niocoder.proxy.impl.UserServiceImpl;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class ProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();
    }
}
