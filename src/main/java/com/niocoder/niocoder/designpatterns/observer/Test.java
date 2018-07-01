package com.niocoder.niocoder.designpatterns.observer;

/**
 * Created on 2018/7/1.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);

        server.setInfomation("php是世界上最好的语言");

        System.out.println("------------");
        server.registerObserver(userLi);
        System.out.println("java是世界上最好的语言");
    }
}
