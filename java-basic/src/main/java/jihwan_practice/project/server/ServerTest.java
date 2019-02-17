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
    List<Board> list = (List<Board>) in.readObject();
    for(Board l : list) {
      System.out.println(l);
    }
  }

  public static void quit() throws Exception {
    out.writeUTF("quit");
    out.flush();
    System.out.println(in.readUTF());
  }
}
