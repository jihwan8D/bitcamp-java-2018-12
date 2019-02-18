package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.proxy.LessonProxy;

public class LessonListCommand implements Command {
  
  Scanner keyboard;
  LessonProxy lessonAgent;
  
  public LessonListCommand(Scanner keyboard, LessonProxy lessonAgent) {
    this.keyboard = keyboard;
    this.lessonAgent = lessonAgent;
  }
  
  @Override
  public void execute() {
    try {
      List<Lesson> lessons = lessonAgent.findAll();
      for (Lesson lesson : lessons) {
        System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
            lesson.getNo(), lesson.getTitle(), 
            lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
      }
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
