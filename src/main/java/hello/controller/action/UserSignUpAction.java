package hello.controller.action;

import hello.dao.UserDAO;
import hello.dto.UserVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserSignUpAction implements Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserVO vo = new UserVO();
        vo.setUserId(req.getParameter("userId"));
        vo.setPassword(req.getParameter("password"));

        UserDAO dao = UserDAO.getInstance();
        dao.insertUser(vo);

        new BoardListAction().execute(req, resp);
    }
}
