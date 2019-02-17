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
  static ArrayList<Board> list = new ArrayList<>();

  public static void main(String[] args) {


    try (ServerSocket ss = new ServerSocket(8888)){
      System.out.println("서버 시작");

      while (true) {
        try (Socket socket = ss.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          
          System.out.println("클라이언트와 연결되었음.");
          list.clear();
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

  static void quit() throws Exception {
    out.writeUTF("종료함!");
    out.flush();
  }
  
  static void add() throws Exception {
    list.add((Board)in.readObject());
    out.writeUTF("OK");
  }
  
  static void list() throws Exception {
    out.writeObject(list);
  }

}

