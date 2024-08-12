package com.devcourse.ycjung.day_0812.aop.ver04_annotation;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("daewon")
public class Boy {
    public void makeTaco() throws Exception {
        System.out.println("멕시칸 타코를 만든다."); // 핵심 관심사항
        if (new Random().nextBoolean()) {
            throw new Exception("끝났다!!!"); // 수행 도중 만약 예외가 발생한다며?
        }
    }
}
