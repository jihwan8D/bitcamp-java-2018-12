package bitcamp.lms;

import java.util.Scanner;
import bitcamp.lms.handler.*;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    LessonHandler myLesson = new LessonHandler();
    myLesson.keyboard = keyboard;//LessonHandler에 있는 키보드에 App클레스에 있는 키보드값을 넣음

    MemberHandler myMember = new MemberHandler();
    myMember.keyboard = keyboard;

    BoardHandler myBoard1 = new BoardHandler();
    myBoard1.keyboard = keyboard;
    BoardHandler myBoard2 = new BoardHandler();
    myBoard2.keyboard = keyboard;
    BoardHandler myBoard3 = new BoardHandler();
    myBoard3.keyboard = keyboard;

    while (true) {

      String command = prompt();

      if (command.equals("/lesson/add")) {
        myLesson.addLesson();   

      } else if (command.equals("/lesson/list")) {
        myLesson.listLesson();

      } else if (command.equals("/member/add")) {
        myMember.addmember();

      } else if (command.equals("/member/list")) {
        myMember.listMember();

      } else if (command.equals("/board1/add")) {
        myBoard1.addBoard();

      } else if (command.equals("/board1/list")) {
        myBoard1.listBoard();

      }else if (command.equals("/board2/add")) {
        myBoard2.addBoard();

      } else if (command.equals("/board2/list")) {
        myBoard2.listBoard();

      }else if (command.equals("/board3/add")) {
        myBoard3.addBoard();

      } else if (command.equals("/board3/list")) {
        myBoard3.listBoard();

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
