package com.devcourse.ycjung.day_0812.aop.ver04_annotation;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 각각의 작업에 대해서 정의
 */
@Component
@Aspect // 다른 핵심관심사항 들에게 공통적으로 적용할 사항들
public class CommonAspect {

    @Pointcut("execution(* make*())")
    public void ppp() {}

    @Before("ppp()")
    public void bbbefore() {
        System.out.println("배가 고프다"); // 핵심 관심사항 수행 전에 해야될 일
    }

    @AfterReturning("ppp()")
    public void aaafterReturning() {
        System.out.println("맛있게 먹는다."); // 핵심 관심사항이 정상적으로 종료된게 확인 됐을 떄!
    }

    @AfterThrowing("ppp()")
    public void aaafterThrowing() {
        System.out.println("엄마를 부른다~"); // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단.
    }

    @After("ppp()")
    public void aaafter() {
        System.out.println("설거지를 한다."); // 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
    }

}
