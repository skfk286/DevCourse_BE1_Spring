package com.devcourse.ycjung.day_0812.aop.ver04_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);

        Boy daewon = context.getBean("daewon", Boy.class);
        daewon.makeTaco();

        Girl jieun = context.getBean("jieun", Girl.class);
        jieun.makeSamgyepsal();
    }
}
