package bitcamp.ex99;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex99/tt")
public class Test extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    ServletContext sc = this.getServletContext();
    sc.setAttribute("k1", "choi");
    
    HttpSession session = req.getSession();
    session.setAttribute("k2", "ji");
    
    req.setAttribute("k3", "hwan");
  
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    out.println("보관소에 값을 넣었습니다. - /ex99/tt");
  
  }
}
