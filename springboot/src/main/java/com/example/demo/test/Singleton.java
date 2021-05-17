package com.example.demo.test;

public class Singleton {
    //    使用final修饰是防止被继承
    private static final Singleton singleton = new Singleton();

    private int Singleton() {
        return 1;
    }

    public static Singleton getInstance() {
        System.out.println(singleton);
        return singleton;
    }

    public static void main(String[] args) {
        getInstance();
    }
}
