package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import jihwan_practice.project.server.domain.Board;

public class BoardService {
  ObjectOutputStream out;
  ObjectInputStream in;
  String request;
  ArrayList<Board> boards = new ArrayList<>();


  public void command(String request) throws Exception {
    switch (request) {
      case "/board/add":
        add();
        break;
      case "/board/list":
        list();
        break;
      case "/board/update":
        update();
        break;
      case "/board/delete":
        delete();
        break;
      case "/board/detail":
        detail();
        break;
      default:
        out.writeUTF("이 명령을 처리할 수 없음!");
    }
    out.flush();
  }




  private void add() throws Exception {
    out.writeUTF("OK");
    out.flush();
    boards.add((Board)in.readObject());
  }

  private void list() throws Exception {
    out.writeUTF("OK");
    out.writeUnshared(boards);
  }

  private void update() throws Exception {
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

  private void delete() throws Exception {
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

  private void detail() throws Exception {
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
}
