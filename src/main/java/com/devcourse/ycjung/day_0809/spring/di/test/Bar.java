package com.devcourse.ycjung.day_0809.spring.di.test;

import org.springframework.stereotype.Component;

@Component
public class Bar {
    private String name;

    public Bar() {

    }

    public void print() {
        System.out.println("Bar..");
    }

}
