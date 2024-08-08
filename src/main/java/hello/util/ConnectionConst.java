package hello.util;
// 객체 생성을 방지하기위해 abstract 키워드 사용
public abstract class ConnectionConst {
    public static final String URL = "jdbc:mysql://localhost:3306/server";
    public static final String USER = "root";
    public static final String PASSWORD = "kfcayo123";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
}
