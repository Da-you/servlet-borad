package hello.util;


import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.util.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

class DBManagerTest {

    @Test
    void connectionTest() {
        Connection connection = DBManager.getConnection();
        assertThat(connection).isNotNull();
    }

    @Test
    void driverManager() throws SQLException {
        Connection conn1 = DriverManager.getConnection(URL, USER, PASSWORD);
        Connection conn2 = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println(conn1.getClass());
        System.out.println(conn2.getClass());
    }

}