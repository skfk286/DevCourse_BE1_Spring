package com.devcourse.ycjung.spring.di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Driver {

    public static final String FILE_XML_PATH = "com/devcourse/ycjung/spring/di/xml/beans.xml";
    public static final String FILE_SYSTEM_XML_PATH = "/src/main/java/com/devcourse/ycjung/spring/di/xml/beans.xml";

    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext(FILE_XML_PATH);
        ApplicationContext context = new FileSystemXmlApplicationContext(FILE_SYSTEM_XML_PATH);
        Car c1 = (Car) context.getBean("sonata1");
        Car c2 = (Car) context.getBean("sonata2");

        c1.printInfo();
        c2.printInfo();
    }
}
