package com.niocoder.niocoder.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        super();
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------before---------------");
        Object invoke = method.invoke(object, args);
        System.out.println("-------------after---------------");
        return invoke;
    }

    public Object getProxy(){
        return  Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(), this.object.getClass().getInterfaces(), this);
    }
}
