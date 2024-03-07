package com.miaoshaproject.error;

import java.math.BigDecimal;

/**
 * @Author:asher
 * @Date:7/14/23 11:56
 * @Description:com.miaoshaproject.error
 * @Version:1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(EmBusinessErr.class);
        System.out.println(EmBusinessErr.class.getSuperclass());
        double d1=1000.0,d2=0.001;
        double d3=d1+d2;
        System.out.println("d3=" + d3);
        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c);

        BigDecimal _a = new BigDecimal("0.02");
        BigDecimal _b = new BigDecimal("0.03");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);
    }
}
