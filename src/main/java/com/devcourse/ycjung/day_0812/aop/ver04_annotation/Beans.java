package com.devcourse.ycjung.day_0812.aop.ver04_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.devcourse.ycjung.day_0812.aop.ver04_annotation")
@EnableAspectJAutoProxy
public class Beans {
}
