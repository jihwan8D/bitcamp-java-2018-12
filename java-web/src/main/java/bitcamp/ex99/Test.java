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
    sc.setAttribute("xx", "choi");
    
    HttpSession session = req.getSession();
    session.setAttribute("yy", "ji");
    
    req.setAttribute("zz", "hwan");
    
    
  
  }
}
