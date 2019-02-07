package bitcamp.lms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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


  private static void loadMemberData() { // 저장한걸 불러오는 메서드

    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("member.data")))) {

      int len = in.readInt();

      for (int i = 0; i < len; i++) {
        
        Member member = new Member();
        member.setNo(in.readInt());
        member.setName(in.readUTF());
        member.setEmail(in.readUTF());
        member.setPassword(in.readUTF());
        member.setPhoto(in.readUTF());
        member.setTel(in.readUTF());
        member.setRegisteredDate(Date.valueOf(in.readUTF()));
        
        memberList.add(member);
      }

    } catch (Exception e) {
      System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());
    } 
  }

  private static void saveMemberData() { // 입력한 내용을 저장하는 메서드
    try (DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("member.data")))) {

      out.writeInt(memberList.size());
      for (Member m : memberList) {
        out.writeInt(m.getNo());
        out.writeUTF(m.getName());
        out.writeUTF(m.getEmail());
        out.writeUTF(m.getPassword());
        out.writeUTF(m.getPhoto());
        out.writeUTF(m.getTel());
        out.writeUTF(m.getRegisteredDate().toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private static void loadBoardData() { // 저장한걸 불러오는 메서드

    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("board.data")))) {

      int len = in.readInt();

      for (int i = 0; i < len; i++) {

        Board board = new Board();
        board.setNo(in.readInt());
        board.setContents(in.readUTF());
        board.setCreatedDate(Date.valueOf(in.readUTF()));
        board.setViewCount(in.readInt());

        boardList.add(board);
      }

    } catch (Exception e) {
      System.out.println("게시글 데이터를 읽는 중 오류 발생: " + e.toString());
    } 
  }

  private static void saveBoardData() { // 입력한 내용을 저장하는 메서드
    try (DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("board.data")))) {

      out.writeInt(boardList.size());
      for (Board board : boardList) {
        out.writeInt(board.getNo());
        out.writeUTF(board.getContents());
        out.writeUTF(board.getCreatedDate().toString());
        out.writeInt(board.getViewCount());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void loadLessonData() { // 저장한걸 불러오는 메서드

    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("lesson.data")))) {

      int len = in.readInt();

      for(int i = 0; i< len; i++) {
        Lesson lesson = new Lesson();
        lesson.setNo(in.readInt());
        lesson.setTitle(in.readUTF());
        lesson.setContents(in.readUTF());
        lesson.setStartDate(Date.valueOf(in.readUTF()));
        lesson.setEndDate(Date.valueOf(in.readUTF()));
        lesson.setTotalHours(in.readInt());;
        lesson.setDayHours(in.readInt());

        lessonList.add(lesson);
      }

    } catch (Exception e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());

    } 
  }

  private static void saveLessonData() { // 입력한 내용을 저장하는 메서드
    try (DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("lesson.data")))) {

      out.writeInt(lessonList.size());
      for (Lesson lesson : lessonList) {
        out.writeInt(lesson.getNo());
        out.writeUTF(lesson.getTitle());
        out.writeUTF(lesson.getContents());
        out.writeUTF(lesson.getStartDate().toString());
        out.writeUTF(lesson.getEndDate().toString());
        out.writeInt(lesson.getTotalHours());
        out.writeInt(lesson.getDayHours());

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}