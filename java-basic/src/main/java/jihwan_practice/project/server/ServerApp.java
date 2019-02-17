package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import jihwan_practice.project.server.domain.Board;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;
  static ArrayList<Board> boards = new ArrayList<>();

  public static void main(String[] args) {


    try (ServerSocket ss = new ServerSocket(8888)){
      System.out.println("서버 시작");

      while (true) {
        try (Socket socket = ss.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

          System.out.println("클라이언트와 연결되었음.");
          boards.clear();
          ServerApp.in = in;
          ServerApp.out = out;


          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);

            switch (request) {
              case "quit":
                quit();
                break loop;
              case "add":
                add();
                break;
              case "list":
                list();
                break;
              case "update":
                update();
                break;
              case "delete":
                delete();
                break;
              case "detail":
                detail();
                break;
              default:
                out.writeUTF("이 명령을 처리할 수 없음!");
            }
            out.flush();
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

  static void add() throws Exception {
    boards.add((Board)in.readObject());
    out.writeUTF("OK");
  }

  static void list() throws Exception {
    out.writeUTF("OK");
    out.writeUnshared(boards);
  }

  private static void update() throws Exception {
    int index = 0;

    Board board = (Board)in.readObject();
    
    for(Board b : boards) {
      if (b.getNo() == board.getNo()) {
        boards.set(index, board);
        out.writeUTF("수정완료");
        return;
      }
      index++;
    }
    out.writeUTF("해당 번호가 없습니다.");
  }

  static void delete() throws Exception {
    int num = in.readInt();
    int index = 0;
    
    for (Board b : boards) {
      if (b.getNo() == num) {
        boards.remove(index);
        out.writeUTF("해당 번호의 게시물 삭제 완료");
        return;
      }
      index++;
    }
      out.writeUTF("해당 번호가 없습니다.");
  }
  
  private static void detail() throws Exception {
    int num = in.readInt();
    
    for (Board b : boards) {
      if (b.getNo() == num) {
        out.writeUTF("OK");
        out.writeObject(b);
        return;
      }
    }
    out.writeUTF("FAIL");
  }
  
  static void quit() throws Exception {
    out.writeUTF("종료함!");
  }


}

