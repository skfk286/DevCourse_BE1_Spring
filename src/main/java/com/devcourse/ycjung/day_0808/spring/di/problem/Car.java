package com.devcourse.ycjung.day_0808.spring.di.problem;

// 비즈니스 로직을 처리하는 서비스 클래스(사용자 권한 체크, 포인트 계산, 트랜잭션 담당<숭금하기> : update + update )
public class Car {
    // 여기서 JDBC 코딩을 다 하긴 좀 지저분, SQL 실행 역할을 맡은 객체를 데리고 있다가 일 시킨다.
    //private KoreaTire koreaTire = new KoreaTire();
    private ChinaTire chinaTire = new ChinaTire();
    private String model;
    private String color;

    // 예를 들면 송금같은 비즈니스 로직 처리 함수를 작성하는 일
    public void printInfo() {
        System.out.println("차량 모델 : " + model); // 잔액 체크(select)
        System.out.println("색상 :" + color); // 출금 처리(insert or update)

        // SQL 실해이 필요할 때는 이렇게 부하직원 객체에게 일 시킴 -> 입급 처리 (insert or update)
        // System.out.println("장착된 타이어 : " + koreaTire.getModel());
        System.out.println("장착된 타이어 : " + chinaTire.getModel());

    }
}
