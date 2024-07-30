package hello.controller;

import hello.HelloServlet;
import hello.controller.action.Action;
import hello.controller.action.BoardPostFormAction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// TODO: url 패턴과 매칭 시켜주는 어노테이션
@WebServlet(urlPatterns = "/BoardServlet")
public class BoardServlet extends HelloServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        System.out.println("BoardServlet에서 요청 확인" + command);

        ActionFactory af = ActionFactory.getInstance();
        Action action = af.getAction(command);
        if (action != null) {
            action.execute(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
