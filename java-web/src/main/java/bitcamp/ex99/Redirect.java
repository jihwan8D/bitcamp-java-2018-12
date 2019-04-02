package bitcamp.ex99;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex99/t3")
public class Redirect extends HttpServlet {
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    resp.setContentType("text/HTML;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    out.println("<html><head>");
    out.println("<title>리다이렉트</title>");
    out.println("</head><body>");
    out.println("안녕하세요! - /ex08/s3");
    for (int i = 0; i < 10; i++) {
      out.println("안녕하세요 - /ex/08/s3");
    }
    out.println("</body></html>");
    
    resp.sendRedirect("t100");
  }

}
