// 데이터 처리 관련 코드를 별도의 클래스로 분리
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {
  void insert(Lesson lesson);
  List<Lesson> findAll();
  Lesson findByNo(int no);
  int update(Lesson lesson);
  int delete(int no);
}







