package hello.dao;

import hello.dto.UserVO;
import hello.util.DBCPUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public UserDAO() {
    }

    private static UserDAO instance = new UserDAO();

    public static UserDAO getInstance() {
        return instance;
    }

    // 회원 가입
    public void insertUser(UserVO userVO) {
        String sql = "insert into users("
                + "userId, password)"
                + "values(?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBCPUtils.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userVO.getUserId());
            pstmt.setString(2, userVO.getPassword());
            pstmt.executeUpdate();
            System.out.println("Insert User sign up successful");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBCPUtils.close(conn, pstmt);
        }
    }



    // 회원 확인 메서드
    public int login(String userId, String password) {
        int result = -1; // 회원 존재시 1, 없다면 -1 리턴
        String sql = "select password from users where userId = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBCPUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password") != null && rs.getString("password").equals(password)) {
                    result = 1;
                } else {
                    result = 0;
                }
            } else {
                result = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCPUtils.close(conn, pstmt, rs);
        }
        return result;
    }

    // 아이디로 회원 정보 가져오는 메서드
    public UserVO getUser(String userId) {
        UserVO userVO = null;
        String sql = "select * from users where userId =?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBCPUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                userVO = new UserVO();
                userVO.setSerialId(rs.getInt("serialId"));
                userVO.setUserId(rs.getString("userId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCPUtils.close(conn, pstmt, rs);
        }
        return userVO;
    }
    // 중복 userId 확인
    public boolean duplicateUserIdCheck(String userId) {
        boolean result = false;
        String sql = "select * from users where userId = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBCPUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = false;
            } else {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBCPUtils.close(conn, pstmt, rs);
        }
        return result;
    }
}
