package com.devcourse.ycjung.day_0819.my_board.controller;

import com.devcourse.ycjung.day_0819.my_board.model.MyBoardDTO;
import com.devcourse.ycjung.day_0819.my_board.model.MyBoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/myMain.do")
public class MyMainServlet extends HttpServlet {
    private MyBoardService myBoardService = MyBoardService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<MyBoardDTO> boardList = null;
        try {
            boardList = myBoardService.findAllBoards();
            req.setAttribute("boardList", boardList);
            req.getRequestDispatcher("/WEB-INF/views/myboard/main.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "[시스템] 데이터를 처리중에 에러가 발생했습니다. ");
            req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
        }
    }
}
