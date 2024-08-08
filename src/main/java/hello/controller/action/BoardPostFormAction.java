package hello.controller.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
// 작성 페이지로 이동하는 클래스
public class BoardPostFormAction implements Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("loginUser") == null) {
            resp.sendRedirect( "/user/userLogin.jsp");
            return;
        }
        String url = "/board/boardPost.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp); // Todo: ?

    }
}
