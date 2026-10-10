package com.example.iov.lab._026_10_10springiocdilab2.beanmethod;

import lombok.Data;


public class User {
    private String name;
    private int age;

    public User(){

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}