package com.flannery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// 1. java字符串是否相等的三种判断方法
// https://blog.csdn.net/baidu_31295661/article/details/122347042
// == 比较的是否是同一对象
// String.equals()返回值为boolean类型，比较两个对象的内容是否相同
// compareTo()方法返回值为int类型，主要用于比较两字符串的大小
public class main {

    public static void main(String[] args) {
        //extracted();
        testFloat3();
        System.out.println(LocalDate.now().lengthOfYear());
        System.out.println(LocalDate.of(2012, 1, 1).lengthOfYear());

        testString();
    }

    public static void testString() {
        // 代码1
        String s1 = new String("ab") + new String("c");
        String s2 = "abc";
        s1.intern();
        System.out.println(s1 == s2);


    }

    private static void testFloat3() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        if(x.compareTo(y) == 0) {
            System.out.println(true);
        }
        if(x == y) {
            System.out.println(true);
        }
    }

    private static void testFloat2() {
        float a = 1.0F - 0.9F;
        float b = 0.9F - 0.8F;
        float diff = 1e-6F;
        if(Math.abs(a - b) < diff) {
            System.out.println("true");
        }
    }

    private static void testFloat() {
        // 错误示例
        float a = 1.0F - 0.9F;
        float b = 0.9F - 0.8F;
        if(a == b){
            System.out.println("a==b");
        }
        System.out.println(a);
        System.out.println(b);

        Float x = Float.valueOf(a);
        Float y = Float.valueOf(b);
        if(x.equals(y)) {
            System.out.println("x.equals(y)");
        }

        // 正确示例 1

        // 正确示例 2

    }

    private static void extracted() {
        System.out.println("start !");
        System.out.println(("Hello" + "World").equals("HelloWorld"));
        System.out.println("Hello" + "World" == "HelloWorld");
        System.out.println(new String("Hello") == "Hello");
        System.out.println("end !");
    }

}
