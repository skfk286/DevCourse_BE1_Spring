package com.devcourse.ycjung.day_0812.aop.ver05_aop_proxy;

public class CAfter implements IAfter {
    @Override
    public void doAfter() {
        System.out.println("설거지를 합니다.");
    }
}
