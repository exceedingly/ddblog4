package com.example.markdown.controller;

import com.example.markdown.bean.MarkDownInfo;

public class test {
    public static void main(String[] args) throws ClassNotFoundException {

        MarkDownInfo markDownInfo = new MarkDownInfo();

        //   对象的方式获得
        Class c1 = markDownInfo.getClass();
        System.out.println(c1.hashCode());
        //   路径的获得
        Class c2 = Class.forName("com.example.markdown.bean.MarkDownInfo");
        System.out.println(c2.hashCode());
        //   对象名称方式获得
        Class c3 = MarkDownInfo.class;
        System.out.println(c3.hashCode());

        //基本内置类型都有一个 type 属性
        Class c4 = Integer.TYPE;
        System.out.println(c4.hashCode());

    }


}
