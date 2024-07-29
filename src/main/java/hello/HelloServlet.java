package hello;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AdditionServlet03")
public class HelloServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int num1 = 1;
    int num2 = 2;
    int sum = num1 + num2;

    req.setAttribute("num1", num1);
    req.setAttribute("num2", num2);
    req.setAttribute("sum", sum);
    RequestDispatcher dispatcher =
        req.getRequestDispatcher("/addition03.jsp");
    dispatcher.forward(req, resp);
  }
}
