package bitcamp.lms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import bitcamp.lms.domain.Board;
import bitcamp.lms.domain.Lesson;
import bitcamp.lms.domain.Member;
import bitcamp.lms.handler.BoardAddCommand;
import bitcamp.lms.handler.BoardDeleteCommand;
import bitcamp.lms.handler.BoardDetailCommand;
import bitcamp.lms.handler.BoardListCommand;
import bitcamp.lms.handler.BoardUpdateCommand;
import bitcamp.lms.handler.Command;
import bitcamp.lms.handler.LessonAddCommand;
import bitcamp.lms.handler.LessonDeleteCommand;
import bitcamp.lms.handler.LessonDetailCommand;
import bitcamp.lms.handler.LessonListCommand;
import bitcamp.lms.handler.LessonUpdateCommand;
import bitcamp.lms.handler.MemberAddCommand;
import bitcamp.lms.handler.MemberDeleteCommand;
import bitcamp.lms.handler.MemberDetailCommand;
import bitcamp.lms.handler.MemberListCommand;
import bitcamp.lms.handler.MemberUpdateCommand;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비
  static Stack<String> commandHistory = new Stack<>();
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();
  static ArrayList<Lesson> lessonList = new ArrayList<>();
  static ArrayList<Board> boardList = new ArrayList<>();
  static ArrayList<Member> memberList = new ArrayList<>();
  public static void main(String[] args) {

    // 데이터 로딩
    try {
      loadLessonData();
      loadMemberData();
      loadBoardData();
      
    } catch(Exception e) {
      System.out.println("저장된 데이터가 없습니다.");
    }
    
    
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
        quit();
        break;
        /*************************************************************/
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
        /*************************************************************/
      } else if (command.equals("history2")) {
        printCommandHistory(commandHistory2.iterator());
        /*************************************************************/
      } 
//      else if (command.equals("loading")) {
//        loading();
//      }
      else {
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
      /*************************************************************/
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
  private static  void quit() {
    saveLessonData();  // 입력한 값 저장
    saveMemberData();
    saveBoardData();
    System.out.println("안녕!");
  }
  private static void loadLessonData() { // 저장한걸 불러오는 메서드

    try (FileReader in = new FileReader("lesson.csv");
        Scanner in2 = new Scanner(in)) {
      while(true) {
  //      String line = in2.nextLine(); // 번호, 제목, 내용, 시작일, 종료일, 총강의시간, 일강의시간
  //      lessonList.add(Lesson.valueOf(line));
  //              ┗ 위 두 줄 아래 코드로 대체 
        lessonList.add(Lesson.valueOf(in2.nextLine()));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();

    } catch (IOException e) {
      e.printStackTrace();
      
    } catch (NoSuchElementException e) {
      System.out.println("수업 데이터 로딩 완료");
    }
  }
  
  private static void loadMemberData() { // 저장한걸 불러오는 메서드

    try (FileReader in = new FileReader("member.csv");
        Scanner in2 = new Scanner(in)) {
      while(true) {
  //      String line = in2.nextLine(); // 번호, 제목, 내용, 시작일, 종료일, 총강의시간, 일강의시간
  //      lessonList.add(Lesson.valueOf(line));
  //              ┗ 위 두 줄 아래 코드로 대체 
        memberList.add(Member.valueOf(in2.nextLine()));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();

    } catch (IOException e) {
      e.printStackTrace();
      
    } catch (NoSuchElementException e) {
      System.out.println("수업 데이터 로딩 완료");
    }
  }
  
  private static void loadBoardData() { // 저장한걸 불러오는 메서드

    try (FileReader in = new FileReader("board.csv");
        Scanner in2 = new Scanner(in)) {
      while(true) {
  //      String line = in2.nextLine(); // 번호, 제목, 내용, 시작일, 종료일, 총강의시간, 일강의시간
  //      lessonList.add(Lesson.valueOf(line));
  //              ┗ 위 두 줄 아래 코드로 대체 
        boardList.add(Board.valueOf(in2.nextLine()));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();

    } catch (IOException e) {
      e.printStackTrace();
      
    } catch (NoSuchElementException e) {
      System.out.println("수업 데이터 로딩 완료");
    }
  }

  private static void saveLessonData() { // 입력한 내용을 저장하는 메서드
    try (FileWriter out = new FileWriter("lesson.csv");) {
      for (Lesson lesson : lessonList) {
        out.write(String.format("%s,%s,%s,%s,%s,%d,%d\n", 
            lesson.getNo(),
            lesson.getTitle(),
            lesson.getContents(),
            lesson.getStartDate(),
            lesson.getEndDate(),
            lesson.getTotalHours(),
            lesson.getDayHours()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private static void saveMemberData() { // 입력한 내용을 저장하는 메서드
    try (FileWriter out = new FileWriter("member.csv");) {
      for (Member member : memberList) {
        out.write(String.format("%s,%s,%s,%s,%s,%s,%s\n", 
            member.getNo(),
            member.getName(),
            member.getEmail(),
            member.getPassword(),
            member.getPhoto(),
            member.getTel(),
            member.getRegisteredDate()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private static void saveBoardData() { // 입력한 내용을 저장하는 메서드
    try (FileWriter out = new FileWriter("board.csv");) {
      for (Board board : boardList) {
        out.write(String.format("%s,%s,%s,%d\n", 
            board.getNo(),
            board.getContents(),
            board.getCreatedDate(),
            board.getViewCount()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}