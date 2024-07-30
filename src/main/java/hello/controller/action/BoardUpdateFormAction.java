package hello.controller.action;

import hello.dao.BoardDAO;
import hello.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateFormAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/board/boardUpdate.jsp";

        String num = req.getParameter("num");

        BoardDAO dao = BoardDAO.getInstance();
        dao.updateReadCount(num);

        BoardVO board = dao.selectDetailBoardByNum(num);
        req.setAttribute("board", board);
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
