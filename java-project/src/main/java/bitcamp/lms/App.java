package bitcamp.lms;

import java.util.Scanner;

public class App {


  static Scanner keyboard = new Scanner(System.in);

  //static int i = 0;

  public static void main(String[] args) {

    String qna;

    while(true) {
      qna = prompt();
      if(qna.equals("/lesson/add")) {
        LessonHandler.addLesson();
        continue;
      } else if(qna.equals("/lesson/list")) {
        LessonHandler.listLesson();
      } else if(qna.equals("/member/add")) {
        MemberHandler.addMember();
        continue;
      } else if(qna.equals("/member/list")) {
        MemberHandler.listMember();
      } else if(qna.equals("/board/add")) {
        BoardHandler.addBoard();
        continue;
      } else if(qna.equals("/board/list")) {
        BoardHandler.listBoard();
      } else if(qna.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else {
        System.out.println("실행할 수 없는 명령어입니다.");
      }
    }
  }
  ///////////////////////////////////////
  public static String prompt() {
    String qna;
    System.out.print("명령> ");
    qna = keyboard.nextLine();
    return qna;
  }
}