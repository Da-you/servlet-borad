package hello.dao;

import hello.dto.BoardVO;
import hello.util.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 게시글 테이블을 엑세스 = 직접 DB에 엑세스
public class BoardDAO {

    public BoardDAO() {
    }

    private static BoardDAO instance = new BoardDAO(); // 싱글톤

    public static BoardDAO getInstance() {
        return instance;
    }
    // 전체 게시글 조회
    public List<BoardVO> selectAllBoards() {
        String sql = "select * from board order by num desc";

        List<BoardVO> list = new ArrayList<BoardVO>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setNum(rs.getInt("num"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setReadCount(rs.getInt("readCount"));
                board.setCreateDate(rs.getTimestamp("createDate"));

                list.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, stmt, rs);
        }
        return list;
    }
}
