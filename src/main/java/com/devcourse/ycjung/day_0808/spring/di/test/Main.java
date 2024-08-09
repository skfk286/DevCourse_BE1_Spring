package com.devcourse.ycjung.day_0808.spring.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static final String FILE_SYSTEM_XML_PATH = "/src/main/java/com/devcourse/ycjung/spring/di/test/beans.xml";

    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext(FILE_SYSTEM_XML_PATH);

        Foo foo = (Foo)context.getBean("foo");
        foo.getBar().print();

    }
}
