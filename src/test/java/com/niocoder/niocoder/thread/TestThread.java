package com.niocoder.niocoder.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程循环答应ABC 10 次
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class TestThread {

    private int count;

    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    class ThreadA implements Runnable {

        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.println("...A");
                    try {
                        b.signal();
                        a.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
        }
    }

    class ThreadB implements Runnable {

        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.println("...B");
                    try {
                        c.signal();
                        b.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
        }
    }

    class ThreadC implements Runnable {

        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.println("...C");
                    count++;
                    try {
                        a.signal();
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
        }
    }


    public static void main(String[] args) {
        TestThread printABCD = new TestThread();
        new Thread(printABCD.new ThreadA()).start();
        new Thread(printABCD.new ThreadB()).start();
        new Thread(printABCD.new ThreadC()).start();
    }
}
