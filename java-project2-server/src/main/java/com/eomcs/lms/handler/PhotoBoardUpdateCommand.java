package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardUpdateCommand extends AbstractCommand {
  
  PhotoBoardDao photoBoardDao;
  
  public PhotoBoardUpdateCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }
  
  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setNo(response.requestInt("번호?"));
    photoBoard.setTitle(response.requestString("제목?"));
    
    if (photoBoardDao.update(photoBoard) == 0) {
      response.println("해당 번호의 게시물이 없습니다.");
      return;
    }
    
    response.println("변경했습니다.");
  }
}
