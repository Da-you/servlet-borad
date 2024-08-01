package hello.controller;

import hello.controller.action.Action;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// TODO: 서블릿 3.0에서 추가되었으며 서블릿 클래스의 요청을 위한 URL 매핑을 쉽게 해준다(web.xml 대신 사용)
@WebServlet(urlPatterns = "/BoardServlet")
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // Todo : JVM은 버전 ID가 다른 다른 객체의 직력화된 형태와 연결하는 것을 거부, 클래스는 명시적으로 serialVersionUID 필드를 정의해 클래스 버전에 따른 고유 번호를 포함하기 때문

    // 요청 메서드
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command"); // request.getParameter()는 input 태그에 입력된 값을 읽어 옴
        System.out.println("BoardServlet 요청 확인" + command);

        ActionFactory af = ActionFactory.getInstance();
        Action action = af.getAction(command);
        if (action != null) {
            action.execute(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
