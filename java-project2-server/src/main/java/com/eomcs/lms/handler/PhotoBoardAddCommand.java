package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardAddCommand extends AbstractCommand {
  
  PhotoBoardDao photoboardDao; 
  
  public PhotoBoardAddCommand(PhotoBoardDao photoboardDao) {
    this.photoboardDao = photoboardDao;
  }
  
  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(response.requestString("제목?"));
    photoBoard.setLessonNo(response.requestInt("수업번호?"));
    photoboardDao.insert(photoBoard);
    
    response.println("저장하였습니다.");
  }
}



