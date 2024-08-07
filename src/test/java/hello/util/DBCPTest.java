package hello.util;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class DBCPTest {

    @Test
    void connectTest() throws SQLException {
        DBCPUtils.getConnection();
    }

    @Test
    void queryTest() {
        String sql = "select 1";
        int result = 0;
        try (Connection con = DBCPUtils.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("호출");
        assertThat(result).isEqualTo(1);
    }


}