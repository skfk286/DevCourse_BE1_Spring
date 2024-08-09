package com.devcourse.ycjung.day_0809.spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 기존에 객체 관리 창고 파일이 xml 이었는데, 그걸 대체하는 자바.(즉, 일반적인 객체 생성을 위한 클래스가 아님)
@ComponentScan("com.devcourse.ycjung.day_0809.spring")
public class Beans {
}
