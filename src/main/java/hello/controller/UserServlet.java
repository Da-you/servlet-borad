package hello.controller;

import hello.controller.action.Action;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // doGet 방식에서 인코딩의 경우 server.xml 파일에 Connector URIEncoding="UTF-8" />을 추가
        String command = req.getParameter("command");
        System.out.println("UserServlet 요청 인입 확인" + command);

        ActionFactory af = ActionFactory.getInstance();
        Action action = af.getAction(command);
        if (action != null) {
            action.execute(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // post 방식의 경우 한글이 깨지지 않도록 인코딩 방식을 지정
        doGet(req, resp);
    }
}
