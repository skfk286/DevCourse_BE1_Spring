package com.devcourse.ycjung.day_0819.my_board.model;

import java.sql.SQLException;
import java.util.List;

public interface MyBoardRepository {
    int insert(MyBoardDTO board) throws SQLException;
    //    int update(MyBoardDTO board, String category) throws SQLException;
    int update(MyBoardDTO board) throws SQLException;
    int delete(int no)throws SQLException;
    List<MyBoardDTO> selectAll()throws SQLException;
    MyBoardDTO selectOne(int id)throws SQLException;
}
