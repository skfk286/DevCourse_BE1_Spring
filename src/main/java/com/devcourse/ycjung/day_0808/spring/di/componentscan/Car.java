package com.devcourse.ycjung.day_0808.spring.di.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    // Strate 패턴의 핵심 : 의존하는 객체를 구체적으로 지정하지 않는다! 의존하는 객체의 결합도를 느슨하게 만든다.

    private Tire tire;
    private String model;
    private String color;

    public Car() {}
    public Car(Tire tire) {
        this.tire = tire;
    }

    public Car(String model, String color, Tire tire) {
        this.model = model;
        this.color = color;
        this.tire = tire;
    }

    @Autowired
    public void setTire(Tire tire) {
        this.tire = tire;
    }

    // 예를 들면 송금같은 비즈니스 로직 처리 함수를 작성하는 일
    public void printInfo() {
        System.out.println("차량 모델 : " + model); // 잔액 체크(select)
        System.out.println("색상 :" + color); // 출금 처리(insert or update)

        // mysql, oracle 상관 없고 insert 만 진행하겠다.
        System.out.println("장착된 타이어 : " + tire.getModel());

    }
}
