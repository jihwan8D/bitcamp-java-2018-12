// 보관소에 값 넣기 - forward 서블릿끼리 ServletRequest 공유하는 것 테스트
package bitcamp.ex9;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex9/s11")
@SuppressWarnings("serial")
public class Servlet11 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트 방법:
    // => http://localhost:8080/java-web/ex09/s11
    //
    // 
    
    // 1) ServletContext 보관소에 값 넣기 
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "xxx");
//  시작돼서 종료될때 유지됨 누구나 접근가능
    
    // 2) HttpSession 보관소에 값 넣기 
    // => 이 요청을한 클라이언트가 HttpSession 객체가 없다면 만들어준다.
    // => 이미 이 클라이언트를 위해 만든 객체가 있따면 그 객체를 리턴한다.
    HttpSession session = request.getSession();
    session.setAttribute("v2", "yyy");
//  같은 브라우저면 같은 서버로 취급한다.(session아이디가 같으면 같은브라우저로 인식)
//  서버에게 세션아이디를 제시했는데 크롬과 파이어폭스는 다른 세션아이디라 값을 못가져옴
//   => 같은 브라우저는 값을 공유하지만 다른 클라이언트는 값을 공유하지 않는다.
    
    // 3) ServletRequest 보관소에 값 넣기
    request.setAttribute("v3", "zzz");
    
    request.getRequestDispatcher("s12").forward(request, response);

  }
}

