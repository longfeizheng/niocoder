package com.niocoder.niocoder.thread;

/**
 * Created on 2018/6/17.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class DeadLockDemo {

    private static String A ="A";
    private static String B ="B";

    public static void main(String[] args) {
        new DeadLockDemo().deadlock();
    }

    private void deadlock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        System.out.println("a........");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println(1);
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    System.out.println("B........");
                    synchronized (A){
                        System.out.println(2);
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
