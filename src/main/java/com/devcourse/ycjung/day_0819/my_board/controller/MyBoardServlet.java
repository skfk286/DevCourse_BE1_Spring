package com.devcourse.ycjung.day_0819.my_board.controller;

import com.devcourse.ycjung.day_0813.simple_board.model.BoardDTO;
import com.devcourse.ycjung.day_0819.my_board.model.MyBoardDTO;
import com.devcourse.ycjung.day_0819.my_board.model.MyBoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/myBoard.do")
public class MyBoardServlet extends MyMainServlet {
    private MyBoardService myBoardService = MyBoardService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String loginId = (String) req.getSession().getAttribute("loginId");
        try {
            if ("write".equals(action)) {
                if (loginId == null) {
                    req.setAttribute("msg", "글을 등록하려면 로그인이 필요합니다. 로그인 페이지로 전환합니다.");
                    req.setAttribute("path", req.getContextPath() + "/user?action=login");
                    req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
                }
                String title = req.getParameter("title");
                String content = req.getParameter("content");

                MyBoardDTO myBoardDTO = new MyBoardDTO(title, content, loginId);
            }
            else if ("view".equals(action)) {
                int no = Integer.parseInt(req.getParameter("no"));

                MyBoardDTO boardDTO = myBoardService.findOneBoard(no);
                req.setAttribute("boardDTO", boardDTO);

                req.getRequestDispatcher("/WEB-INF/views/myboard/view.jsp").forward(req, resp);
            } else if ("remove".equals(action)) {
                if (loginId == null) {
                    req.setAttribute("msg", "글을 삭제하려면 로그인이 필요합니다. 로그인 페이지로 전환합니다.");
                    req.setAttribute("path", req.getContextPath() + "/user?action=login");
                    req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
                }
                System.out.println("삭제...");
                int no = Integer.parseInt(req.getParameter("no"));
                int result = myBoardService.deleteBoard(no);

                if(result >= 1) {
                    req.setAttribute("msg", "글을 정상적으로 삭제하였습니다.");
                    req.setAttribute("path", req.getContextPath() + "/myMain.do");
                    req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "[시스템] 데이터를 처리중에 에러가 발생했습니다. ");
            req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String loginId = (String) req.getSession().getAttribute("loginId");
        try {
            if ("write".equals(action)) {
                if (loginId == null) {
                    req.setAttribute("msg", "글 쓰기를 하려면 로그인이 필요합니다. 로그인 페이지로 전환합니다.");
                    req.setAttribute("path", req.getContextPath() + "/user?action=login");
                    req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
                }

                String title = req.getParameter("title");
                String content = req.getParameter("content");

                MyBoardDTO boardDTO = new MyBoardDTO(title, content, loginId);
                int result = myBoardService.addBoard(boardDTO);

                if(result >= 1) {
                    req.setAttribute("msg", "글을 정상적으로 작성하였습니다.");
                    req.setAttribute("path", req.getContextPath() + "/myMain.do");
                    req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
                }
            } else if("modify".equals(action)) {
                if (loginId == null) {
                    req.setAttribute("msg", "글을 수정하려면 로그인이 필요합니다. 로그인 페이지로 전환합니다.");
                    req.setAttribute("path", req.getContextPath() + "/user?action=login");
                    req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
                }

                MyBoardDTO boarDTO = new MyBoardDTO();
                boarDTO.setNo(Integer.parseInt(req.getParameter("no")));
                boarDTO.setTitle(req.getParameter("title"));
                boarDTO.setContent(req.getParameter("content"));

                int result = myBoardService.modifyBoard(boarDTO);
                if(result >= 1) {
                    req.setAttribute("msg", "글을 정상적으로 수정하였습니다.");
                    req.setAttribute("path", req.getContextPath() + "/myMain.do");
                    req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "[시스템] 데이터를 처리중에 에러가 발생했습니다. ");
            req.getRequestDispatcher("/WEB-INF/views/myboard/alert/alert.jsp").forward(req, resp);
        }
    }
}
