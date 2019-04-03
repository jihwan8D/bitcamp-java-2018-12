// 쿠키- 유효기간 설정하기
package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/s21")
@SuppressWarnings("serial")
public class Servlet21 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트 방법:
    // => http://localhost:8080/java-web/ex10/s21
    //
    
    // 쿠키 사용범위
    // => 쿠키의 사용 범위를 지정하지 않으면 쿠키를 발행한 URL 범위에 한정된다.
    //    즉 같은 URL로 요청할 때만 쿠키를 보내야 한다.
    // => 예)
    //    쿠키를 발행항 URL : /ex10/s21
    //    쿠키를 보낼 수 있는 URL : /ex10/*
    //    쿠키를 보낼 수 없는 URL : /ex10 이외의 모든 URL
    
    // 사용 범위를 지정하지 않은 쿠키
    Cookie c1 = new Cookie("v1", "aaa");

    // 사용 범위를 지정
    Cookie c2 = new Cookie("v2", "bbb");
    c2.setPath("/java-web/ex10/a");
        
    
    Cookie c3 = new Cookie("v3", "ccc");
    c3.setPath("/java-web");
    

    // 쿠키를 응답 헤더에 포함시키기
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("/ex10/s21 - 쿠키 보냈습니다.");
  }
}

