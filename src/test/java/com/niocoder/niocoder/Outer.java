package com.niocoder.niocoder;

/**
 * Created on 2018/5/31.
 *
 * @author zlf
 * @since 1.0
 */
public class Outer {
    private int a = 100;
    private static int b = 10;

    public class Inner {
        public void innerMethod(){
            System.out.println("outer a " +a);
            System.out.println("outer b " +b);
            Outer.this.action();
        }
    }

    private void action(){
        System.out.println("action");
    }

    public void test(){
        Inner inner = new Inner();
        inner.innerMethod();
    }
}
