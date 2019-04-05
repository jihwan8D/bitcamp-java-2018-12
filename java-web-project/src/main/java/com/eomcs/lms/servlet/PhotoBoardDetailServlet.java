package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@WebServlet("/photoboard/detail")
@SuppressWarnings("serial")
public class PhotoBoardDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    PhotoBoardService photoBoardService = 
        iocContainer.getBean(PhotoBoardService.class);
    LessonService lessonService = 
        iocContainer.getBean(LessonService.class);
    
    int no = Integer.parseInt(request.getParameter("no"));

    List<PhotoBoard> photoBoards = photoBoardService.list(0, null);
    PhotoBoard board = (PhotoBoard) photoBoardService.get(no);
    
    List<PhotoFile> files = board.getFiles();
    
    List<Lesson> lessons = lessonService.list();
    
    request.setAttribute("photoBoard", board);
    request.setAttribute("photoFile", files);
    
    request.setAttribute("lessons", lessons);
    
    response.setContentType("text/html;charset=UTF-8");

    request.getRequestDispatcher("/photoboard/detail.jsp").include(request, response);
    
  }

}