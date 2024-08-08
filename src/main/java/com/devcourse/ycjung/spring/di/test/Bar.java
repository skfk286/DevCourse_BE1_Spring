package com.devcourse.ycjung.spring.di.test;

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
