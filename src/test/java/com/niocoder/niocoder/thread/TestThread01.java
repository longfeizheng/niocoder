package com.niocoder.niocoder.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个打印10次一个打印5次 循环打印两次
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class TestThread01 {

    private int count;

    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();

    class MainThread implements Runnable{
        @Override
        public void run() {
            while (true){
                lock.lock();
                if(count<2){
                    for(int i=0;i<10;i++){
                        System.out.println("主线程执行："+i);
                    }
                }
                try {
                    b.signal();
                    a.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class SubThread implements Runnable{
        @Override
        public void run() {
            while (true){
                lock.lock();
                if(count<2){
                    for(int i=0;i<5;i++){
                        System.out.println("子线程执行："+i);
                    }
                }
                count++;
                try {
                    a.signal();
                    b.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        TestThread01 testThread01 = new TestThread01();
        new Thread(testThread01.new MainThread()).start();
        new Thread(testThread01.new SubThread()).start();
    }
}
