package com.devcourse.ycjung.spring.di.componentscan;

import org.springframework.stereotype.Component;

// @Component
public class ChinaTire implements Tire {

    @Override
    public String getModel() {
        return "중국";
    }
}
