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

  public static void main(String[] args) {


    try (ServerSocket ss = new ServerSocket(8888)){
      System.out.println("서버 시작");

      while (true) {
        try (Socket socket = ss.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          System.out.println("클라이언트와 연결되었음.");

          ServerApp.out = out;
          ServerApp.in = in;
          BoardService boardService = new BoardService(in, out);
          LessonService lessonService = new LessonService(in, out);
          MemberService memberService = new MemberService(in, out);

          lessonService.lessons.clear();
          memberService.members.clear();
          boardService.boards.clear();

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

