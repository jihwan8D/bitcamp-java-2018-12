package bitcamp.lms;

import java.util.Scanner;
import bitcamp.lms.handle.BoardHandler;
import bitcamp.lms.handle.LessonHandler;
import bitcamp.lms.handle.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  final public static int LENGTH = 10;

  public static void main(String[] args) {
  
    while (true) {
      LessonHandler.keyboard = keyboard;//LessonHandler에 있는 키보드에 App클레스에 있는 키보드값을 넣음
      MemberHandler.keyboard = keyboard;
      BoardHandler.keyboard = keyboard;
      
      String command = prompt();

      if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();   

      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();

      } else if (command.equals("/member/add")) {
        MemberHandler.addmember();

      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();

      } else if (command.equals("/board/add")) {
        BoardHandler.addBoard();

      } else if (command.equals("/board/list")) {
        BoardHandler.listBoard();

      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println(); // 결과 출력 후 빈 줄 출력
    }
    keyboard.close();
  }
  static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
