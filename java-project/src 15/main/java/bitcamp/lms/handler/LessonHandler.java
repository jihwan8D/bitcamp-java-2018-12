package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Lesson;

public class LessonHandler {

  Scanner keyboard;

  final int LENGTH = 10;

  Lesson[] lessons = new Lesson[LENGTH];
  Lesson lesson = new Lesson();

  int lessonIdx = 0;
  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void addLesson() {
    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
    lessons[lessonIdx] = lesson;
    lessonIdx++;

    System.out.println("저장하였습니다.");
  }

  public void listLesson() {
    for (int j = 0; j < lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lessons[j].getNo(), lessons[j].getTitle(), lessons[j].getStartDate(), 
          lessons[j].getEndDate(), lessons[j].getTotalHours());
    }
  }

}
