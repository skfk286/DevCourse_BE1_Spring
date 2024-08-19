package com.devcourse.ycjung.day_0819.my_board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/myUser.do")
public class MyUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("login".equals(action)) {
            HttpSession session = req.getSession();
            String loginId = (String)session.getAttribute("loginId");

            if(loginId == null) {
                req.getRequestDispatcher("/WEB-INF/views/myboard/login.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/myMain.do");
            }
        } else if ("logout".equals(action)) {
            HttpSession session = req.getSession();
            session.invalidate();

            req.setAttribute("msg", "로그아웃 되었습니다.");
            req.setAttribute("path", req.getContextPath() + "/");
            req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String userpw = req.getParameter("userpw");

        if (userid.equals("grepp") && userpw.equals("1234")) {
            // login success
            HttpSession session = req.getSession(); // 지금 요청보낸 사용자
            session.setAttribute("loginId", userid);

            req.setAttribute("msg", "로그인 완료되었습니다.");
            req.setAttribute("path", req.getContextPath() + "/"); // 맨 첫페이지로 보냄.
            req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "로그인 실패입니다. 아이디나 패스워드를 다시 확인해 주세요.");
            req.setAttribute("path", req.getContextPath() + "/user?action=login"); // 로그인 페이지로 보냄.
            req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
            // login fail
        }
    }
}
