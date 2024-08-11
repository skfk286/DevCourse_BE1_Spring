package com.devcourse.ycjung.user_register;

public interface PasswordEncoder {
    // 패스워드를 해시화한다.
    String encode(CharSequence rawPassword);
}
