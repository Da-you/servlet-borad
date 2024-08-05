package hello.util;

import java.sql.*;

import static hello.util.ConnectionConst.*;

// DB Connection 객체를 얻고 해제를 담당하는 클래스
public class DBManager {

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); // Todo :  실제로 db와 연결되어 작업을 수행할 수 있는 통로로 작용하는 객체 변수로 해당 객체가 생성되면 db 접근이 가능해진다.
            System.out.println("DB connection success");
            return conn;
        } catch (SQLException e) {
            System.out.println("DB connection failed");
            throw new IllegalStateException(e);
        }
    }

    // select를 수행한후 리소스 해제
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DML(insert, update, delete) 수행후 리소스 해제
    public static void close(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
