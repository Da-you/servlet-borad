package hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    String id = req.getParameter("id");
    String password = req.getParameter("password");

    PrintWriter out =resp.getWriter();
    out.print("<html><body>");
    out.println("아이디 : ");
    out.println(id);
    out.println("<br> 비밀번호 :");
    out.println(password);
  }
}
