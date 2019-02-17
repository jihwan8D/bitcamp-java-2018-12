package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import jihwan_practice.project.server.domain.Board;

public class BoardTest {
  ObjectOutputStream out;
  ObjectInputStream in;

  BoardTest(ObjectOutputStream out,  ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }
  public void test() throws Exception {
    add(new Board(1, "게시글 1"));
    add(new Board(2, "게시글 2"));
    list();

    update(new Board(1, "수정된 게시물 1111"));
    add(new Board(3, "게시글 3"));

    detail(2);
    delete(3);

    list();
  }
  private void add(Board board) throws Exception {
    out.writeUTF("/board/add");
    out.flush();
    String state = in.readUTF();
    if (!state.equals("OK")) {
      System.out.println("명령을 실행할 수 없습니다.");
      return;
    }
    out.writeObject(board);
    out.flush();
  }

  private void list() throws Exception {
    out.writeUTF("/board/list");
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

  private void update(Board board) throws Exception {
    out.writeUTF("/board/update");
    out.writeObject(board);
    out.flush();
    System.out.println(in.readUTF());
  }

  private void delete(int num) throws Exception {
    out.writeUTF("/board/delete");
    out.writeInt(num);
    out.flush();
    System.out.println(in.readUTF());
  }

  private void detail(int num) throws Exception {
    out.writeUTF("/board/detail");
    out.writeInt(num);
    out.flush();

    String status = in.readUTF();
    if(!status.equals("OK")) {
      System.out.println("해당 게시물 찾지 못함");
    } else {
      System.out.println((Board)in.readObject());
    }
  }
}
