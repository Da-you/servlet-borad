package hello.controller.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 다형성을 가지기 위한 인터페이스
public interface Action {
    // 요청 파리미터를 동이한 메서드로 처리하기 위한 추상 메서드 정의
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
