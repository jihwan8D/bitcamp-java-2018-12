package bitcamp.ex99;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex99/t2")
public class RefreshHTML extends HttpServlet {
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/HTML;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>");
    out.println("<meta http-equiv='Refresh' content='3;url=t100'>");
    out.println("</head><body>");
    out.println("안녕, Hi! - /ex99/t2");
    out.println("</body></html>");
  }
}
