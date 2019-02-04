package com.zhzye.aspectj;

public class Person {
    public void hi() {
        System.out.println("person hi");
    }

    public String say() {
        System.out.println("person say");
        return "hi, zhzye[return].";
    }
}
