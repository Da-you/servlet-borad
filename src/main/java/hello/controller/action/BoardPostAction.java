package hello.controller.action;

import hello.dao.BoardDAO;
import hello.dao.UserDAO;
import hello.dto.BoardVO;
import hello.dto.UserVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardPostAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("세션 값 : " + req.getSession().getAttribute("loginUser"));
        String userId = req.getSession().getAttribute("loginUser").toString();
        BoardVO vo = new BoardVO();

        vo.setTitle(req.getParameter("title"));
        vo.setContent(req.getParameter("content"));
        vo.setUserId(userId);

        BoardDAO dao = BoardDAO.getInstance();
        dao.insertBoard(vo);

        new BoardListAction().execute(req, resp);
    }
}
