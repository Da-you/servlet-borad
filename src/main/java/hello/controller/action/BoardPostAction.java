package hello.controller.action;

import hello.dao.BoardDAO;
import hello.dto.BoardVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

public class BoardPostAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardVO vo = new BoardVO();

        vo.setTitle(req.getParameter("title"));
        vo.setContent(req.getParameter("content"));

        BoardDAO dao = BoardDAO.getInstance();
        dao.insertBoard(vo);

        new BoardListAction().execute(req, resp);
    }
}
