package com.devcourse.ycjung.day_0819.my_board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/myAlert.do")
public class MyAlertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("write_success".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/views/myboard/alert/success.jsp").forward(req, resp);
        }
    }
}
