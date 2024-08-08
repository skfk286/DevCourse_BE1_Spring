package com.devcourse.ycjung.spring.di.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Foo {
    private final Bar bar;

    @Autowired
    public Foo(Bar bar) {
        System.out.println("Foo.. 의존주입 실행");
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }
}