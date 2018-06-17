package com.niocoder.niocoder.thread;

/**
 * Created on 2018/6/17.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class SyncObjTest {

    public static void main(String[] args) {

        final SyncObj sy = new SyncObj();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sy.showA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sy.showB();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sy.showC();
            }
        }).start();
    }
}
