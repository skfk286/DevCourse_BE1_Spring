package com.devcourse.ycjung.day_0809.spring.di.componentscan;

import org.springframework.stereotype.Component;

// @Component
public class ChinaTire implements Tire {

    @Override
    public String getModel() {
        return "중국";
    }
}
