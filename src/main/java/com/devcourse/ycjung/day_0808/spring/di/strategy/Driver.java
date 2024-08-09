package com.devcourse.ycjung.day_0808.spring.di.strategy;

public class Driver {
    public static void main(String[] args) {
        // 실제 사용 예제..
        // 핵심은 디자인 패턴이 무엇인지..
        Car car = new Car("BMW", "White", new KoreaTire());
        car.printInfo();

        car.setTire(new ChinaTire());
        car.printInfo();
    }
}
