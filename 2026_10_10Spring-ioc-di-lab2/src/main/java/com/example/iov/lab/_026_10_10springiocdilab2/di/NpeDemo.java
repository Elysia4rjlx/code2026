package com.example.iov.lab._026_10_10springiocdilab2.di;


public class NpeDemo {

    public static void main(String[] args) {
        String name = null;

        // 1 这样写不会报错
        System.out.println("拼接 null：" + name);

        // 2 取消下面这行的注释，会 NPE
        System.out.println(name.length());
    }
}