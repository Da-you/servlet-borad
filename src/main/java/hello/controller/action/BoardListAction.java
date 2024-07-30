package hello.controller.action;

import hello.dao.BoardDAO;
import hello.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 게시글 리스트를 위한 액션 클래스
public class BoardListAction implements Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/board/boardList.jsp";

        BoardDAO dao = BoardDAO.getInstance();

        List<BoardVO> list = dao.selectAllBoards();

        req.setAttribute("boardList", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
