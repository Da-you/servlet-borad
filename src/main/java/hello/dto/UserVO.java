package hello.dto;

import java.sql.Timestamp;

public class UserVO {
    private int serialId;
    private String userId;
    private String password;
    private Timestamp createdAt;

    public int getSerialId() {
        return serialId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
