package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import jihwan_practice.project.server.service.BoardService;
import jihwan_practice.project.server.service.LessonService;
import jihwan_practice.project.server.service.MemberService;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;

  static BoardService boardService;
  static LessonService lessonService;
  static MemberService memberService;

  public static void main(String[] args) {

    try {
      boardService = new BoardService();
      boardService.loadData("board.bin");
    } catch (Exception e) {
      System.out.println("게시판 데이터 로딩 중 오류 발생!");
    }

    try {
      lessonService = new LessonService();
      lessonService.loadDate("lesson.bin");
    } catch (Exception e) {
      System.out.println("수업 데이터 로딩 중 오류 발생!");
    }

    try {
      memberService = new MemberService();
      memberService.loadDate("member.bin");
    } catch(Exception e) {
      System.out.println("회원 데이터 로딩 중 오류 발생!");
    }

    try (ServerSocket ss = new ServerSocket(8888)){
      System.out.println("서버 시작");

      while (true) {
        try (Socket socket = ss.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          System.out.println("클라이언트와 연결되었음.");

          ServerApp.out = out;
          ServerApp.in = in;

          boardService.inOut(in, out);
          lessonService.inOut(in, out);
          memberService.inOut(in, out);

          while (true) {
            String request = in.readUTF();
            System.out.println(request);

            if(request.startsWith("/board/")) {
              boardService.command(request);

            } else if(request.startsWith("/lesson/")) {
              lessonService.command(request);

            } else if(request.startsWith("/member/")) {
              memberService.command(request);
            } 
            else if(request.equalsIgnoreCase("quit")) {
              quit();
              break;
            } else {
              out.writeUTF("FAIL");
            }
          }

        } catch (Exception e) {
          e.printStackTrace();        
        }
        System.out.println("클라이언트와의 연결을 끊었음.");
      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }
  } // main



  static void quit() throws Exception {
    out.writeUTF("종료함!");
    out.flush();

    try {
      boardService.saveDate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      lessonService.saveDate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      memberService.saveDate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }


}

