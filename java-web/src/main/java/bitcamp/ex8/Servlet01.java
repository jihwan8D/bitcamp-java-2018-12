// 리프래시 - 클라이언트에게 다른 URL을 요청하라는 명령
package bitcamp.ex8;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex8/s1")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {
  
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
    
    out.println("안녕하세요! - /ex08/s1");
    
    for (int i = 0; i < 1000; i++) {
      out.println(i + "  ===> 1234568790123456879012345687901234568790");
    }
    
    // 응답 헤더에 Refresh 정보를 추가한다.
                // Refresh 3초후에 지정한곳으로 요청하라
    response.setHeader("Refresh", "3;url=s100"); // 3초후에 s100으로 이동한다.
    // 버퍼에 다 차기전에 이 명령문을 써놓으면 정상적으로 실행된다.
  }
}

