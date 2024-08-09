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
        String num = req.getParameter("num");
        String userId = req.getSession().getAttribute("loginUser").toString();
        BoardDAO dao = BoardDAO.getInstance();
        dao.updateReadCount(num);

        BoardVO board = dao.selectDetailBoardByNum(num);
        if (!userId.equals(dao.selectDetailBoardByNum(num).getUserId())) {
            throw new IllegalArgumentException("해당 게시글의 수정 권한이 없습니다.");
        }
        String url = "/board/boardUpdate.jsp";

        req.setAttribute("board", board);
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
