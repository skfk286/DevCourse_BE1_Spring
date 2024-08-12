package com.devcourse.ycjung.day_0808.spring.di.componentscan;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("ch")
public class ChinaTire implements Tire {

    @Override
    public String getModel() {
        return "중국";
    }
}
