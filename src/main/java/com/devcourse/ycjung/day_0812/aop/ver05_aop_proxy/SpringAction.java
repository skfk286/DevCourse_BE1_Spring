package com.devcourse.ycjung.day_0812.aop.ver05_aop_proxy;

import org.springframework.web.servlet.HttpServletBean;

/**
 * 스프링 AOP 를 실제 구현해본다면..
 */
public class SpringAction {

    public static void main(String[] args) throws Exception {
        Boy daewon = new Boy(); // 직접 객체 생성 안하고 스프링한테 달라고 했었죠.

        // daewon.makeFood(); // 이걸 실행하는 줄 알았는데.

        /**
         * 스프링은 아래와 같이 실행 가능한 프록시를 줘서 실행했을 것.
         */
        PersonProxy daewonProxy = new PersonProxy();
        daewonProxy.setTarget(daewon); // 타코로..
        daewonProxy.setBefore(new CBefore());
        daewonProxy.setAfterReturn(new CAfterReturning());
        daewonProxy.setAfterThorow(new CAfterThrowing());

        daewonProxy.setTarget(new Girl()); // 삽겹살로..

        daewonProxy.makeFood();

        HttpServletBean hsb;
    }
}
