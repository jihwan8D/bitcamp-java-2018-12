package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoFileListCommand extends AbstractCommand {

  PhotoFileDao photoFileDao;
  
  public PhotoFileListCommand(PhotoFileDao photoFileDao) {
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) {
    List<PhotoFile> boards = photoFileDao.findAll();
    
    for (PhotoFile board : boards) {
      response.println(
          String.format("%3d, %s", 
            board.getNo(), 
            board.getFilePath()));
    }
  }

}
