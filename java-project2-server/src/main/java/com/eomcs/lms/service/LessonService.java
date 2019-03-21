package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonService {
  List<Lesson> list();
  int add(Lesson board);
  Lesson get(int no);
  int update(Lesson board);
  int delete(int no);
}
