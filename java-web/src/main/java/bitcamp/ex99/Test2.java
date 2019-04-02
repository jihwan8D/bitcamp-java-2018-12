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

@WebServlet("/ex99/tt2")
public class Test2 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse response)
      throws ServletException, IOException {
    
    ServletContext sc = this.getServletContext();
    String k1 = (String) sc.getAttribute("k1");
    
    HttpSession session = req.getSession();
    String k2 = (String) session.getAttribute("k2");
    
    String k3 = (String) req.getAttribute("k3");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("보관소에 저장된 값 꺼내기 - /ex09/s2");
    out.printf("v1 = %s\n", k1);
    out.printf("v2 = %s\n", k2);
    out.printf("v3 = %s\n", k3);
    
    
    
  }
}
