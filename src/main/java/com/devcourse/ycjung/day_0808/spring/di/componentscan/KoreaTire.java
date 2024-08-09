package com.devcourse.ycjung.day_0808.spring.di.componentscan;

import org.springframework.stereotype.Component;
// Tire 표준에 맞춰서 클래스 작성(Tire 가 구현하라는 거 다 구현 필요)
@Component
public class KoreaTire implements Tire {

    @Override
    public String getModel() { // insert
        return "한국"; // mysql insert 구현했다 가정
    }
}
