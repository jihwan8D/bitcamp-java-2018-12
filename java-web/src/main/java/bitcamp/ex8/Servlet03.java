//  
package bitcamp.ex8;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08/s3")
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트 방법:
    // => http://localhost:8080/java-web/ex08/s3
    //
    // 리다이렉트
    // => 클라이언트의 요청을 받은 후 콘텐트를 보내는 대신
    //    다른 페이지의 URL을 알려줄 때 사용한다.
    // => 웹 브라우저는 응답 받는 즉시 해당 페이지를 요청한다.
    // => 리프래시와 달리 서버는 콘텐트(message-body)를 보내지 않는다.
    // => 사용 예:
    //    로그인 후 로그인 결과를 출력하지 않고 즉시 메인 화면으로 보내고 싶을 때
    //    결제완료 후 결과를 출력하지 않고 즉시 결제 상태 페이지로 보내고 싶을 때
    response.setContentType("text/HTML;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>");
    out.println("<title>리다이렉트</title>");
    out.println("</head><body>");
    out.println("안녕하세요! - /ex08/s3");
    for (int i = 0; i < 10; i++) {
      out.println("안녕하세요 - /ex/08/s3");
    }
    out.println("</body></html>");
    
    
    response.sendRedirect("s100"); 
    // => 이 위에 있는 코드는 버려지는데, 만약 버퍼가 꽉채울 만큼의 데이터가 있다면 이 코드는 먹히지 않는다.
  }
}

