package com.niocoder.niocoder;

/**
 * Created on 2018/5/31.
 *
 * @author zlf
 * @since 1.0
 */
public class StaticOuter {

    public StaticOuter(){
        System.out.println("Outer Constructor");
    }
    private static int shared = 100;

    private  int noShared = 100;

    public static class StaticInner{

        public StaticInner(){
            System.out.println("StaticInner Constructor");
        }

        public void innerMethod(){
            System.out.println("inner:"+shared);
        }
    }

    public void test(){
        StaticInner si = new StaticInner();
        si.innerMethod();
    }

    public static void main(String[] args) {
        StaticOuter outer = new StaticOuter();
        outer.test();
//        Outer.StaticInner si = new Outer.StaticInner();
//        si.innerMethod();
    }
}
