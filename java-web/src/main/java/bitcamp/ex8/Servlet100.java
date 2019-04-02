// 리프래시 또는 리다이렉트 최종 요청 페이지
package bitcamp.ex8;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex8/s100")
@SuppressWarnings("serial")
public class Servlet100 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트 방법:
    // => http://localhost:8080/java-web/ex08/s1
    //
    // 리프래시
    // => 서버로부터 응답을 받고 내용을 출력한 후 특정 URL을 자동으로 요청하도록 만들 수 있다.
    // => 보통 웹 페이지를 자동으로 이동시키고 싶을 때 사용한다.
    // 
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("반가워요 - /ex08/s100");
    
  }
}

