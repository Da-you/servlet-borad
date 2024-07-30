package hello.controller.action;

import hello.dao.BoardDAO;
import hello.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
// 게시글 상세 조회로 넘어가기 위한 클래스
public class BoardViewAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/board/boardView.jsp";

        String num = req.getParameter("num");

        BoardDAO dao = BoardDAO.getInstance();
        dao.updateReadCount(num);

        BoardVO board = dao.selectDetailBoardByNum(num);

        req.setAttribute("board", board);
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
