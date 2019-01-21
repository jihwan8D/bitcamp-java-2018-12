package bitcamp.lms;

import java.util.Scanner;
import bitcamp.lms.handle.BoardHandler;
import bitcamp.lms.handle.LessonHandler;
import bitcamp.lms.handle.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

   public static int LENGTH = 10;

 
  
  public static void main(String[] args) {
    LessonHandler lessonHandler = new LessonHandler(keyboard);
    MemberHandler memberHandler = new MemberHandler(keyboard);
    BoardHandler boardHandler = new BoardHandler(keyboard);
    BoardHandler boardHandler2 = new BoardHandler(keyboard);

    while (true) {

      String command = prompt();

      if (command.equals("/lesson/add")) {
        lessonHandler.addLesson();   

      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();

      } else if (command.equals("/member/add")) {
        memberHandler.addmember();

      } else if (command.equals("/member/list")) {
        memberHandler.listMember();

      } else if (command.equals("/board/add")) {
        boardHandler.addBoard();

      } else if (command.equals("/board/list")) {
        boardHandler.listBoard();

      } else if (command.equals("/board2/add")) {
        boardHandler2.addBoard();

      } else if (command.equals("/board2/list")) {
        boardHandler2.listBoard();

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
