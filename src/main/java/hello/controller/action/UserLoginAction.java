package hello.controller.action;

import hello.dao.UserDAO;
import hello.dto.UserVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.invoke.StringConcatFactory;

public class UserLoginAction implements Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserVO vo = new UserVO();
        String userId = req.getParameter("userId");
        String pwd = req.getParameter("password");

        UserDAO dao = UserDAO.getInstance();
        int result = dao.login(userId, pwd);
        if (result == 1) {
            UserVO userVO = dao.getUser(userId);
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", userVO);
            new BoardListAction().execute(req, resp);
        } else if (result == 0) {
            req.setAttribute("message", "비밀번호가 일치하지 않습니다.");
        } else if (result == 0) {
            req.setAttribute("message", "회원이 존재하지 않습니다.");
        }
    }
}
