package hello.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// DB Connection 객체를 얻고 해제를 담당하는 클래스
public class DBManager {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Context context = new InitialContext(); // ?
            Context envContext = (Context) context.lookup("java:/comp/env"); // Todo :
            DataSource ds = (DataSource) envContext.lookup("jdbc/mysql"); // Todo :
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
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

    // DML(insert, update, delete) 수행ㅎ루 리소스 해제
    public static void close(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
