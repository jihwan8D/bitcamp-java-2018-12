package bitcamp.ex99;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex99/t1")
public class Refresh extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    response.setHeader("Refresh", "3;url=t100");
    
    for(int i = 0; i<1000; i++) {
      out.println(i + " =>ssssssssssssssssssssssssssssssssss");
    }
    out.println("리플래시 테스트 : /ex99/t1");
  }
}
