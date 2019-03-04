package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDetailCommand extends AbstractCommand {
  
  PhotoBoardDao photoboardDao;
  
  public PhotoBoardDetailCommand(PhotoBoardDao photoboardDao) {
    this.photoboardDao = photoboardDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    int no = response.requestInt("번호?");
    
    PhotoBoard photoBoard = photoboardDao.findByNo(no);
    if (photoBoard == null) {
      response.println("해당 사진을 찾을 수 없습니다.");
      return;
    }
    response.println(String.format("제목: %s", photoBoard.getTitle()));
    response.println(String.format("작성일: %s", photoBoard.getCreatedDate()));
    response.println(String.format("조회수: %d", photoBoard.getViewCount()));
    response.println(String.format("수업: %s", photoBoard.getLessonNo()));
  }
}
