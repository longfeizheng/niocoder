package com.niocoder.niocoder.designpatterns.observer;

/**
 * Created on 2018/7/1.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class User implements Observer {

    private String name;
    private String message;
    public User(String name){
        this.name=name;
    }



    @Override
    public void update(String message) {
        this.message=message;
        read();
    }

    private void read() {
        System.out.println(name+"收到推送的消息："+message);
    }


}
