package bitcamp.lms.handle;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.App;
import bitcamp.lms.domain.Lesson;

public class LessonHandler {
  public Scanner keyboard;

  public LessonHandler (Scanner keyboard){
    this.keyboard = keyboard;
  }

  //static Scanner keyboard = new Scanner(System.in); // 쓰기는 편한데 메모리 낭비됨. 
  static Lesson[] lessons = new Lesson[App.LENGTH];
  static Lesson lesson = new Lesson();

  static int lessonIdx = 0;

  //함수
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
    for (int j = 0; j < LessonHandler.lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lessons[j].getNo(), lessons[j].getTitle(), lessons[j].getStartDate(), 
          lessons[j].getEndDate(), lessons[j].getTotalHours());
    }
  }

}
