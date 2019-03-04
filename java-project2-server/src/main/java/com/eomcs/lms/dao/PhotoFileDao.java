package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.PhotoFile;

public interface PhotoFileDao {
//  void insert(PhotoBoard photoBoard);
  List<PhotoFile> findAll();
//  PhotoBoard findByNo(int no);
//  int update(PhotoBoard photoBoard);
//  int delete(int no);
}
