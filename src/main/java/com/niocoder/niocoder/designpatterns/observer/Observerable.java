package com.niocoder.niocoder.designpatterns.observer;

/**
 * 被观察者接口
 * Created on 2018/7/1.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface Observerable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
