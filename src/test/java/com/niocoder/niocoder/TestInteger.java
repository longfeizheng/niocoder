package com.niocoder.niocoder;

import org.junit.Test;

/**
 * Created on 2018/5/30.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class TestInteger {

    @Test
    public void test1() throws Exception {
        int sum = 0;
        for (int i = 0; sum != 10; i++) {
            sum = 5 * i + 3;
            if (sum == 10) {
                System.out.println("i=" + i);
            }
        }
        System.out.println("sum=" + sum);
    }


    @Test
    public void test2() throws Exception {

        System.out.println(Integer.MIN_VALUE + Integer.MAX_VALUE);//-1(-128+127=-1)
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);//-2(01111+01111=11110 补码+1=000010 所以为-2)
        System.out.println(Integer.MIN_VALUE + Integer.MIN_VALUE);//0（10000+10000=00000）0
    }

    @Test
    public void test3() {
        int a = 100;
        int b = 100;
        System.out.println(a==b);

        Integer c =100;
        Integer d =100;
        System.out.println(c == d);

        int e = 128;
        int f = 128;
        System.out.println( e == f);

        Integer g = 128;
        Integer h = 128;

        System.out.println(g ==h );//IntegerCache
    }
}
