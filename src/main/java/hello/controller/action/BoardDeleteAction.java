package hello.controller.action;

import hello.dao.BoardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getSession().getAttribute("loginUser").toString();
        String num = req.getParameter("num");

        BoardDAO boardDAO = BoardDAO.getInstance();
        if (!userId.equals(boardDAO.selectDetailBoardByNum(num).getUserId())) {
            throw new IllegalArgumentException("해당 게시글의 삭제 권한이 없습니다.");
        }
        boardDAO.deleteBoard(num);
        new BoardListAction().execute(req, resp);
    }
}
