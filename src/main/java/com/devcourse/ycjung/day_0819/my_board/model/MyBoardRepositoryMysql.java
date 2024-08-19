package com.devcourse.ycjung.day_0819.my_board.model;

import com.devcourse.ycjung.day_0813.simple_board.model.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyBoardRepositoryMysql implements MyBoardRepository {
    private static MyBoardRepositoryMysql instance = new MyBoardRepositoryMysql();

    private MyBoardRepositoryMysql() {}
    public static MyBoardRepositoryMysql getInstance() {
        return instance;
    }

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int insert(MyBoardDTO board) throws SQLException {
        int result = 0;
        try {
            String sql = " INSERT INTO " +
                    " BOARD_TB(TITLE,WRITER,CONTENT,REG_DATE) VALUES(?,?,?,NOW()) ";
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getWriter());
            ps.setString(3, board.getContent());
            result = ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("insert error");
            throw ex;
        }finally {
            DBUtil.close(ps, conn);
        }
        return result;
    }

    @Override
    public int update(MyBoardDTO board) throws SQLException {
        // 위의 update 버전은 수정하고싶은게 뭔지 정확히 찝어서 그것만 수정하기였고
        // 이 update는 수정하고 싶은게 여러개 이면 한꺼번에 수정하도록 값의 유무 체크해서 진행하는 버전
        int result = 0;

        try {
            String sql = " UPDATE BOARD_TB SET ";

            if(board.getTitle()!=null && board.getTitle().length()>0){ // 제목에 변경하고자 값이 확실히 있는지 체크해서
                sql += " TITLE='"+board.getTitle()+"', ";
            }
            if(board.getWriter()!=null && board.getWriter().length()>0){
                sql += " WRITER='"+board.getWriter()+"', ";
            }
            if(board.getContent()!=null && board.getContent().length()>0){
                sql += " CONTENT='"+board.getContent()+"', ";
            }
            sql = sql.substring(0, sql.length()-2);

            sql += " WHERE NO = "+board.getNo();
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("update error");
            throw ex;
        }finally {
            DBUtil.close(ps, conn);
        }

        return result;
    }

    @Override
    public int delete(int no) throws SQLException {
        int result = 0;

        try {
            String sql = "DELETE FROM BOARD_TB WHERE NO = ?";
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, no);

            // 실행 후 영향을 받은 행의 수를 반환
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("delete error");
            throw ex;
        } finally {
            DBUtil.close(null, ps, conn); // ResultSet은 없으므로 null 전달
        }

        return result;
    }

    @Override
    public List<MyBoardDTO> selectAll() throws SQLException {
        List<MyBoardDTO> list = new ArrayList<MyBoardDTO>();
        try {
            String sql = " SELECT NO,TITLE,WRITER,CONTENT,READ_COUNT,REG_DATE FROM BOARD_TB ";
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(makeMyBoardDTO(rs));
            }
        }catch (SQLException ex){
            System.out.println("update error");
            throw ex;
        }finally {
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }

    @Override
    public MyBoardDTO selectOne(int no) throws SQLException {
        MyBoardDTO board = null;

        try {
            String sql = " SELECT NO,TITLE,WRITER,CONTENT,READ_COUNT,REG_DATE FROM BOARD_TB WHERE NO="+no;
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){ // 글번호 이상하면 없을수는 있음.
                board = makeMyBoardDTO(rs);
            }
        }catch (SQLException ex){
            System.out.println("update error");
            throw ex;
        }finally {
            DBUtil.close(rs, ps, conn);
        }

        return board;
    }

    private MyBoardDTO makeMyBoardDTO(ResultSet rs) throws SQLException {
        MyBoardDTO MyBoardDTO = new MyBoardDTO();
        MyBoardDTO.setNo(rs.getInt("NO"));
        MyBoardDTO.setTitle(rs.getString("TITLE"));
        MyBoardDTO.setWriter(rs.getString("WRITER"));
        MyBoardDTO.setContent(rs.getString("CONTENT"));
        MyBoardDTO.setReadCount(rs.getInt("READ_COUNT"));
        MyBoardDTO.setRegDate(rs.getString("REG_DATE"));
        return MyBoardDTO;
    }
}
