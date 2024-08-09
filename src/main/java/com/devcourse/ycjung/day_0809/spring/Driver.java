package com.devcourse.ycjung.day_0809.spring;

import com.devcourse.ycjung.day_0808.spring.di.componentscan.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        Car c1 = (Car) context.getBean("sonata");

        c1.printInfo();
    }
}
