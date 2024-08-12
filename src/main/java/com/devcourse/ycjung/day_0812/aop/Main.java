package com.devcourse.ycjung.day_0812.aop;

import java.util.Random;

/**
 * AOP 고찰
 */
public class Main {
    public static void main(String[] args) {
        Boy daewon = new Boy();
        daewon.makeTaco();

        Girl jieun = new Girl();
        jieun.makeSamgeop();
    }
}
