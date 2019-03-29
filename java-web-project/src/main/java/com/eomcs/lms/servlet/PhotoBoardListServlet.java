package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/list")
public class PhotoBoardListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PhotoBoardService photoBoardService = 
        ServerApp.iocContainer.getBean(PhotoBoardService.class);
    List<PhotoBoard> boards = photoBoardService.list(0, null);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사진 목록</title></head>");
    out.println("<body><h1>사진 목록</h1>");
    out.println("<p><a href='add'>새 사진</a></p>");
    out.println("<table border='1'>");
    out.println("<tr><th>번호</th><th>제목</th><th>등록일</th><th>조회수</th><th>수업</th></tr>");

    for (PhotoBoard board : boards) {
      out.println(String.format(
          "<tr><td>%d</td><td><a href='detail?no=%1$d'>%s</a>"
              + "</td><td>%s</td><td>%d</td><td>%d</td></tr>",
              board.getNo(), 
              board.getTitle(), 
              board.getCreatedDate(), 
              board.getViewCount(),
              board.getLessonNo()));
    }
    out.println("</table>");

    out.println("<form action='search'>");
    out.println("수업번호: <input type='text' name='lessonNo'> ");
    out.println("검색어: <input type='text' name='keyword'> ");
    out.println("<button type='submit'>검색</button>");
    out.println("</form>");

    out.println("</body></html>");
  }
  
}
