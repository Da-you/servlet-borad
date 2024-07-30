package hello.controller.action;

import hello.dao.BoardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");

        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.deleteBoard(num);
        new BoardListAction().execute(req, resp);
    }
}
