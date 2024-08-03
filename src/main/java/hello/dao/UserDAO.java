package hello.dao;

import hello.dto.UserVO;
import hello.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public UserDAO() {
    }

    private static UserDAO instance = new UserDAO();

    public static UserDAO getInstance() {
        return instance;
    }
    // 회원 가입
    public void insertUser(UserVO userVO){
        String sql = "insert into users("
        + "userId, password)"
        + "values(?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userVO.getUserId());
            pstmt.setString(2, userVO.getPassword());
            pstmt.executeUpdate();
            System.out.println("Insert User sign up successful");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt);
        }
    }
    // 로그인
}
