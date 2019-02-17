package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;

  public static void main(String[] args) {
    BoardService boardService = new BoardService();
    LessonService lessonService = new LessonService();
    MemberService memberService = new MemberService();


    try (ServerSocket ss = new ServerSocket(8888)){
      System.out.println("서버 시작");

      while (true) {
        try (Socket socket = ss.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          System.out.println("클라이언트와 연결되었음.");

          ServerApp.out = out;
          ServerApp.in = in;

          lessonService.lessons.clear();
          memberService.members.clear();
          boardService.boards.clear();

          lessonService.out = out;
          lessonService.in = in;
          memberService.out = out;
          memberService.in = in;
          boardService.out = out;
          boardService.in = in;

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
  }


}

