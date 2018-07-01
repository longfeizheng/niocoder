package com.niocoder.niocoder.designpatterns.observer;

import java.util.*;

/**
 * 实现被观察者
 * Created on 2018/7/1.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class WechatServer implements Observerable {

    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }


    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<list.size();i++){
            Observer observer = list.get(i);
            observer.update(message);
        }
    }

    public void setInfomation(String message){
        this.message=message;
        System.out.println("微信服务更新消息。。");
        notifyObserver();
    }
}
