package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class ServerApp {

  static ArrayList<Member> members = new ArrayList<>();
  static ArrayList<Lesson> lessons = new ArrayList<>();
  static ArrayList<Board> boards = new ArrayList<>();

  static ObjectInputStream in;
  static ObjectOutputStream out;

  public static void main(String[] args) {


    try(ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      while(true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

          ServerApp.in = in;
          ServerApp.out = out;

          System.out.println("클라이언트와 연결되었음.");
          members.clear();
          lessons.clear();
          boards.clear();

          
          MemberService memberService = new MemberService(out, in);
          LessonService lessonService = new LessonService(out, in);
          BoardService boardService = new BoardService(out, in);
         
        
          loop: while (true) {
            String request =  in.readUTF();
            System.out.println(request);

            if(request.startsWith("/member/")) {
              memberService.execute(request);

            } else if(request.startsWith("/lesson/")) {
              lessonService.execute(request);

            } else if(request.startsWith("/board/")) {
              boardService.execute(request);
              
            } else if (request.equals("quit")) {
              quit();
              break loop;
              
            } else {
              out.writeUTF("FAIL");
            }
            out.flush();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와 연결을 끊었음.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void quit() throws Exception {
    out.writeUTF("종료함!");
    out.flush();
  }
}
