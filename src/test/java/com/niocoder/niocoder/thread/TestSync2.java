package com.niocoder.niocoder.thread;

/**
 * Created on 2018/6/17.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class TestSync2 implements Runnable{

    int b = 100;

    synchronized void m1() throws InterruptedException{
        System.out.println("m1被执行啦。。。");
        b =1000;
        Thread.sleep(500);
        System.out.println("b= "+b);
    }

    synchronized void m2() throws InterruptedException{
        Thread.sleep(250);
        System.out.println("m2 被执行啦。。。");
        b = 2000;
    }

    public static void main(String[] args)throws InterruptedException {
        TestSync2 tt = new TestSync2();
        Thread t = new Thread(tt);
        t.start();
        tt.m2();
        System.out.println("main Thread b "+tt.b);
    }

    @Override
    public void run() {
        try{
            m1();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
