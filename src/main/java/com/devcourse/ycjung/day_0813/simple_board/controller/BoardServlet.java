package com.devcourse.ycjung.day_0813.simple_board.controller;

import com.devcourse.ycjung.day_0813.simple_board.model.BoardDTO;
import com.devcourse.ycjung.day_0813.simple_board.model.BoardRepository;
import com.devcourse.ycjung.day_0813.simple_board.model.BoardRepositoryMysql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/board.do")
public class BoardServlet extends HttpServlet {
    private BoardRepository repo = BoardRepositoryMysql.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        // 클라이언트가 어떤 링크를 클릭했는지에 따라 다른 행동을 해줘야 한다.
        try {
            if ("list".equals(action)) {
                List<BoardDTO> boardList = repo.selectAll(); // 조회
                req.setAttribute("bList", boardList); // 담고 전달
                req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
            } else if ("writeForm".equals(action)) {
                req.getRequestDispatcher("/WEB-INF/views/board/writeForm.jsp").forward(req, resp);
            } else if ("view".equals(action)) {
                int id = Integer.parseInt(req.getParameter("no"));
                BoardDTO boardDto = repo.selectOne(id);

                req.setAttribute("bbb", boardDto);
                req.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 에러 발생하면 에러 페이지로.
            req.getRequestDispatcher("/WEB-INF/views/board/common/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("write".equals(action)) {
                String title = req.getParameter("tttt");
                String content = req.getParameter("cccc");
                String writer = req.getParameter("wwww");

                BoardDTO boardDTO = new BoardDTO(title, content, writer);

                int result = repo.insert(boardDTO);
//            if( result == 1) {
//                req.getRequestDispatcher("/WEB-INF/views/board/success.jsp").forward(req, resp); // 성공
//            } else {
//                req.getRequestDispatcher("/WEB-INF/views/board/fail.jsp").forward(req, resp); // 실패
//            }
                if(result == 1) {
                    // 이러면 새로운 req 가 생성됨으로 기존 req를 재사용 하는 상황을 막을 수 있다.
                    // 다만 alert.do 처리가 필요
                    resp.sendRedirect(req.getContextPath() + "/alert.do");
                }
            } else if("modify".equals(action)) {
                BoardDTO boardDto = new BoardDTO();
                boardDto.setNo(Integer.parseInt(req.getParameter("no")));
                boardDto.setTitle(req.getParameter("title"));
                boardDto.setContent(req.getParameter("content"));

                int result = repo.update(boardDto);
                if(result >= 1) {
                    resp.sendRedirect(req.getContextPath() + "/alert.do");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
