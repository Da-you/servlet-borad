package hello.controller.action;

import hello.dao.BoardDAO;
import hello.dto.BoardVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

public class BoardUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardVO vo = new BoardVO();


        vo.setTitle(req.getParameter("title"));
        vo.setContent(req.getParameter("content"));
        vo.setNum(Integer.parseInt(req.getParameter("num")));
        BoardDAO dao = BoardDAO.getInstance();
        dao.updateBoard(vo);
        new BoardListAction().execute(req, resp);
    }
}
