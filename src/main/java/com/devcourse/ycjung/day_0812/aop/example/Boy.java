package com.devcourse.ycjung.day_0812.aop.example;

import java.util.Random;

public class Boy {
    public void makeTaco() {
        System.out.println("배가 고프다"); // 핵심 관심사항 수행 전에 해야될 일

        try {
            /////////////////////////////////////////////
            System.out.println("멕시칸 타코를 만든다."); // 핵심 관심사항
            if (new Random().nextBoolean()) {
                throw new Exception("끝났다!!!"); // 수행 도중 만약 예외가 발생한다며?
            }
            /////////////////////////////////////////////
            System.out.println("맛있게 먹는다."); // 핵심 관심사항이 정상적으로 종료된게 확인 됐을 떄!
        } catch (Exception e) {
            System.out.println("엄마를 부른다~"); // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단.
        } finally {
            System.out.println("설거지를 한다."); // 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
        }
    }
}
