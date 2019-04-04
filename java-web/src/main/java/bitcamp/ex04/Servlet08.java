// 썸네일 이미지 만들기
package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

// 멀티파트 형식의 데이터를 처리할 서블릿으로 선언하라.
// => web.xml에 설정할 수도 있고, 다음과 같이 애노테이션으로 설정할 수도 있다.
//
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/ex04/s8")
public class Servlet08 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;
  private String uploadDir;
  
  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    // 테스트
    // - http://localhost:8080/java-web/ex04/test08.html 실행
    //

    req.setCharacterEncoding("UTF-8");
    
    // 파라미터로 받은 ServletRequest를 원래의 타입으로 변환하라.
    HttpServletRequest httpReq = (HttpServletRequest) req;
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<html>");
    out.println("<head><title>servlet04</title></head>");
    out.println("<body><h1>파일 업로드 결과</h1>");
    
    // 일반 폼 데이터를 원래 하던 방식대로 값을 꺼낸다.
    out.printf("이름=%s<br>\n", httpReq.getParameter("name"));
    out.printf("나이=%s<br>\n", httpReq.getParameter("age"));
    
    // 파일 데이터는 getPart()를 이용한다.
    Part photoPart = httpReq.getPart("photo");
    String filename = "";
    if (photoPart.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      filename = UUID.randomUUID().toString();
      photoPart.write(this.uploadDir + "/" + filename);
    }
    
    // 원본 사진을 가지고 특정 크기의 썸네일 이미지를 만들기
    // 1) 썸네일 이미지를 생성해주는 자바 라이브러리 추가
    Thumbnails.of(this.uploadDir + "/" + filename)
      .size(50, 50)
      .outputFormat("jpg").toFiles(Rename.PREFIX_DOT_THUMBNAIL);
    
    out.printf("사진=%s<br>\n", filename);
    out.printf("<img src='../upload/thumbnail.%s.jpg'><br>\n", filename);
    out.printf("<img src='../upload/%s'><br>\n", filename);
    out.println("</body></html>");
  }
}

