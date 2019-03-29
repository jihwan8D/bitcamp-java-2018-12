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
@WebServlet("/photoboard/delete")
public class PhotoBoardDeleteServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    PhotoBoardService photoBoardService = 
        ServerApp.iocContainer.getBean(PhotoBoardService.class);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head>"
        + "<title>사진 삭제</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    out.println("<body><h1>사진 삭제</h1>");
    
    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (photoBoardService.delete(no) == 0) {
        out.println("<p>해당 번호의 사진이 없습니다.</p>");
      } else { 
        out.println("<p>삭제했습니다.</p>");
      }
    } catch (Exception e) {
      out.println("<p>삭제 중 오류 발생.</p>");
    }
    out.println("</body></html>");
  }
}
