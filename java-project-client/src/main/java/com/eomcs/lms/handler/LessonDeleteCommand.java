package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.proxy.LessonProxy;

public class LessonDeleteCommand implements Command {

  Scanner keyboard;
  LessonProxy lessonAgent;
  
  public LessonDeleteCommand(Scanner keyboard, LessonProxy lessonAgent) {
    this.keyboard = keyboard;
    this.lessonAgent = lessonAgent;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      lessonAgent.delete(no);
      System.out.println("삭제했습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
