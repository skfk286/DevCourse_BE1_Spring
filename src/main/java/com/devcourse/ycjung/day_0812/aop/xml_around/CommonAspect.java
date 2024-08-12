package com.devcourse.ycjung.day_0812.aop.xml_around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

/**
 * 각각의 작업에 대해서 정의
 */
public class CommonAspect {
//    public void bbbefore() {
//        System.out.println("배가 고프다"); // 핵심 관심사항 수행 전에 해야될 일
//    }
//
//    public void aaafterReturning() {
//        System.out.println("맛있게 먹는다."); // 핵심 관심사항이 정상적으로 종료된게 확인 됐을 떄!
//    }
//
//    public void aaafterThrowing() {
//        System.out.println("엄마를 부른다~"); // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단.
//    }
//
//    public void aaafter() {
//        System.out.println("설거지를 한다."); // 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
//    }

    // 위에 처럼 전후 다 적용하고자 하는 경우엥는 굳이 하나하나 떼서 만들지 않고 아래처럼 around 를 하면 편하다.
    public Object aaaround(ProceedingJoinPoint target) {
        System.out.println("배가 고프다"); // 핵심 관심사항 수행 전에 해야될 일
        try {
            target.proceed(); // 이 시점에 타코 만들거나 삽겹살 굽거나 그런 일들이 일어날꺼다.
            System.out.println("맛있게 먹는다."); // 핵심 관심사항이 정상적으로 종료된게 확인 됐을 떄!
        } catch (Throwable e) {
            System.out.println("엄마를 부른다~"); // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단.
            throw new RuntimeException(e);
        } finally {
            System.out.println("설거지를 한다."); // 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
        }

        return null;
    }
}
