package com.devcourse.ycjung.day_0813;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dd")
public class ServletD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---- ServletD 의 doGet 호출됨! 아마도 forward.. ----");
        System.out.println("client ip 주소 : " + req.getRemoteAddr());
        System.out.println("요청 url : " + req.getServletPath());
        System.out.println("phone 파라미터 값 : " + req.getParameter("phone"));

        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> 이곳은 ServletD 가 작성한 HTML 화면입니다. </h1>");
        out.println("</body></html>");
    }
}
