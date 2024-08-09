package com.devcourse.ycjung.day_0809.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        Car car = (Car) context.getBean("car");

        car.printInfo();
    }
}
