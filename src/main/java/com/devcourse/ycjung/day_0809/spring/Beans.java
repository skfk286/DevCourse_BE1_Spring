package com.devcourse.ycjung.day_0809.spring;

import com.devcourse.ycjung.day_0808.spring.di.componentscan.Car;
import com.devcourse.ycjung.day_0808.spring.di.componentscan.KoreaTire;
import com.devcourse.ycjung.day_0808.spring.di.componentscan.Tire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 기존에 객체 관리 창고 파일이 xml 이었는데, 그걸 대체하는 자바.(즉, 일반적인 객체 생성을 위한 클래스가 아님)
public class Beans {

    @Bean
    public Tire koreaTire() {
        return new KoreaTire();
    }

    @Bean
    // @Scope // 싱글톤 등 설정 가능
    public Car sonata() {
        Car c = new Car(koreaTire());

        return c;
    }

}
