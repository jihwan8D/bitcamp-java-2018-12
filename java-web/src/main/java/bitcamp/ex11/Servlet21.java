package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/s21")
@SuppressWarnings("serial")
public class Servlet21 extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  
    HttpSession session = request.getSession();
    
    session.setMaxInactiveInterval(10);  
//  => 다시 실행하면 10초카운트가 초기화하고 1초부터 다시 시작. 은행과 비슷하다.    
    session.setAttribute("v1", "aaa");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("/ex11/s21 실행함!");
    
  }
  
}

