package bitcamp.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import bitcamp.lms.domain.Board;
import bitcamp.lms.domain.Lesson;
import bitcamp.lms.domain.Member;
import bitcamp.lms.handler.*;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비
  static Stack<String> commandHistory = new Stack<>();
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();

  public static void main(String[] args) {

    ArrayList<Board> boardList = new ArrayList<>(); // App에서 생성한 객체의 주소를 각 클래스에 보내줌 보내줌 그래야 공유가능
    ArrayList<Member> memberList = new ArrayList<>();
    ArrayList<Lesson> lessonList = new ArrayList<>();

    HashMap<String,Command> commandMap = new HashMap<>();
    //Command 자리에객체가 와야댐
    // LessonAddCommand myLesson = new LessonAddCommand(keyboard, lessonList);
    // commandMap.put("/lesson/add", myLesson);
    // 이렇게 해도 될듯.

    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList)); // App에서 생성한 객체의 주소를 각 클래스에 보내줌 보내줌 그래야 공유가능
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));

    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));

    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));

    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);


      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory(new Iterator<String>() {
          int index = commandHistory.size() - 1;

          @Override
          public boolean hasNext() {
            return index >= 0; 
          }

          @Override
          public String next() {
            return commandHistory.get(index--);
          }
        });

      } else if (command.equals("history2")) {
        printCommandHistory(commandHistory2.iterator());

      } else {
        Command commandHandler = commandMap.get(command);

        if (commandHandler == null) {
          System.out.println("실행할 수 없는 명령입니다.");
        } else if (commandHandler != null) {
          try {
            commandHandler.execute();
          } catch (Exception e) {
            System.out.printf("작업 중 오류 발생: %s\n",e.toString());
          }
        }
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iterator) {
    try {
      int count = 0;
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
        if (++count % 5 == 0) {
          System.out.print(":");
          String input = keyboard.nextLine();
          if (input.equalsIgnoreCase("q"))
            break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}