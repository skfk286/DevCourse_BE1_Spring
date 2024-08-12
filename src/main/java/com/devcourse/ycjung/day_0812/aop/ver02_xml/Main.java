package com.devcourse.ycjung.day_0812.aop.ver02_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static final String FILE_SYSTEM_XML_PATH = "/src/main/java/com/devcourse/ycjung/day_0812/aop/ver02_xml/beans.xml";

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new FileSystemXmlApplicationContext(FILE_SYSTEM_XML_PATH);

        Boy daewon = context.getBean("daewon", Boy.class);
        daewon.makeTaco();

        Girl jieun = context.getBean("jieun", Girl.class);
        jieun.makeSamgyepsal();
    }
}
