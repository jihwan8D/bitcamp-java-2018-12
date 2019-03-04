package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao {
  void insert(PhotoBoard photoboard);
  List<PhotoBoard> findAll();
  PhotoBoard findByNo(int no);
  int update(PhotoBoard photoboard);
  int delete(int no);
}
