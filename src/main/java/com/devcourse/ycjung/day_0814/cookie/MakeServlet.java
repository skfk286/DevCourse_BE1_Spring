package com.devcourse.ycjung.day_0814.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/makeCookie")
public class MakeServlet extends HttpServlet {
    static int cooNum = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("쿠키 발급 요청이 들어와서 쿠키를 발급합니다. : " + cooNum);

        Cookie cookie = new Cookie("ycjungCookie" + cooNum, "hi"+cooNum); // 쿠키이름, 쿠키값
//        cookie.setMaxAge(60*5); // 쿠키 유효시간 설정
//        cookie.setDomain("programmers.co.kr"); // 이 쿠키를 들고갈 도메인
//        cookie.setPath("/checkCookie");

        resp.addCookie(cookie); // 쿠키 발급
        cooNum++; // 쿠키 발급했으니 하나 증가.

        req.getRequestDispatcher("/WEB-INF/views/cookie/makeCookie.jsp").forward(req, resp);
    }
}
