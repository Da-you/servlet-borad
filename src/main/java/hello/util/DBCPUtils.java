package hello.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPUtils {
    private final DataSource dataSource;

    public DBCPUtils(DataSource dataSource) {
        this.dataSource = dataSource;
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

    private Connection getConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println("DBCP conn = " + conn.getClass());
        return conn;
    }
}
