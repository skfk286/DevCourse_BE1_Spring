package com.devcourse.ycjung.day_0819.my_board.model;

import java.sql.SQLException;
import java.util.List;

public class MyBoardService {

    private MyBoardRepository repo = MyBoardRepositoryMysql.getInstance();

    private static MyBoardService myBoardService = new MyBoardService();

    private MyBoardService() {}

    public static MyBoardService getInstance() {
        return myBoardService;
    }

    // 전체 조회
    public List<MyBoardDTO> findAllBoards() throws SQLException {
        return repo.selectAll();
    }
    
    // 단건 조회
    public MyBoardDTO findOneBoard(int bno) throws SQLException {
        return repo.selectOne(bno);
    }

    // 삽입
    public int addBoard(MyBoardDTO dto) throws SQLException {
        return repo.insert(dto);
    }

    // 수정
    public int modifyBoard(MyBoardDTO dto) throws SQLException {
        return repo.update(dto);
    }

    // 삭제
    public int deleteBoard(int bno) throws SQLException {
        return repo.delete(bno);
    }

}
