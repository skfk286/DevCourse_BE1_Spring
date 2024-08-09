package com.devcourse.ycjung.day_0808.spring.di.componentscan;

// DB 작업 하는 애들은 이 표준을 다 갖춰야 함(crud, select one, selectAll)
// 이라고 명시하면 이 인터페이스 구현하는 클래스는 필수로 이 메소드를 다 구현해야 됨.
public interface Tire {

    String getModel();
}
