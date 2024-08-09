package hello.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static hello.util.ConnectionConst.*;

public class DBCPUtils {
    //    private final DataSource dataSource;
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource hikariDs;

    static {
        config.setDriverClassName(DRIVER);
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setPoolName("MY-Pool");
        config.setMinimumIdle(4);
        config.setMaximumPoolSize(10);
        config.setConnectionTimeout(3000);
        System.out.println("hikari 커넥션 풀 생성");
        hikariDs = new HikariDataSource(config);
    }

    private DBCPUtils() {
    }

    // select를 수행한후 리소스 해제
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                System.out.println("커넥션 반환");
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DML(insert, update, delete) 수행후 리소스 해제
    public static void close(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                System.out.println("커넥션 반환");
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        System.out.println("hikariCP conn = " + hikariDs.getConnection().getClass());
        System.out.println("Total Connections: " + hikariDs.getHikariPoolMXBean().getTotalConnections()); // 총 커넥션
        System.out.println("Active Connections: " + hikariDs.getHikariPoolMXBean().getActiveConnections()); // 활동 커넥션
        System.out.println("Idle Connections: " + hikariDs.getHikariPoolMXBean().getIdleConnections()); // 유휴 커넥션
        return hikariDs.getConnection();
    }
}
