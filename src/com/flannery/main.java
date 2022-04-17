package com.flannery;

// 1. java字符串是否相等的三种判断方法
// https://blog.csdn.net/baidu_31295661/article/details/122347042
// == 比较的是否是同一对象
// String.equals()返回值为boolean类型，比较两个对象的内容是否相同
// compareTo()方法返回值为int类型，主要用于比较两字符串的大小
public class main {

    public static void main(String[] args) {
        System.out.println("start !");
        System.out.println(("Hello" + "World").equals("HelloWorld"));
        System.out.println("Hello" + "World" == "HelloWorld");
        System.out.println(new String("Hello") == "Hello");
        System.out.println("end !");
    }

}
