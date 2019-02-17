package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import jihwan_practice.project.server.domain.Board;

public class ServerTest {

  static ObjectOutputStream out;
  static ObjectInputStream in;

  public static void main(String[] args) {

    try (Socket s = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream())) {
      System.out.println("서버와 연결됨");

      ServerTest.in = in;
      ServerTest.out = out;

      out.writeUTF("okok");
      out.flush();
      System.out.println(in.readUTF());
      add(new Board(1, "게시글 1"));
      add(new Board(2, "게시글 2"));
      list();

      update(new Board(1, "수정된 게시물 1111"));
      add(new Board(3, "게시글 3"));

      detail(2);
      delete(3);

      list();


      quit();








    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");
  } // main

  public static void add(Board board) throws Exception {
    out.writeUTF("add");
    out.writeObject(board);
    out.flush();
    System.out.println(in.readUTF());
  }

  public static void list() throws Exception {
    out.writeUTF("list");
    out.flush();
    String state = in.readUTF();

    if(state.equals("OK")) {
      @SuppressWarnings("unchecked")
      List<Board> boards = (List<Board>) in.readObject();
      for(Board l : boards) {
        System.out.println(l);
      }

    } else
      System.out.println("조회 실패");
  }

  public static void update(Board board) throws Exception {
    out.writeUTF("update");
    out.writeObject(board);
    out.flush();
    System.out.println(in.readUTF());
  }

  private static void delete(int num) throws Exception {
    out.writeUTF("delete");
    out.writeInt(num);
    out.flush();
    System.out.println(in.readUTF());
  }

  private static void detail(int num) throws Exception {
    out.writeUTF("detail");
    out.writeInt(num);
    out.flush();
    
    String status = in.readUTF();
    if(!status.equals("OK")) {
      System.out.println("해당 게시물 찾지 못함");
    } else {
      System.out.println((Board)in.readObject());
    }
  }

  public static void quit() throws Exception {
    out.writeUTF("quit");
    out.flush();
    System.out.println(in.readUTF());
  }
}
