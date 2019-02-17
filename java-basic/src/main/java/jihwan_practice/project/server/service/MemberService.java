package jihwan_practice.project.server.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import jihwan_practice.project.server.domain.Member;

public class MemberService {
  public ObjectInputStream in;
  public ObjectOutputStream out;
  public ArrayList<Member> members = new ArrayList<>();
  String request;

  public MemberService(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }
  
  public void command(String request) throws Exception {
    switch (request) {
      case "/member/add":
        add();
        break;
      case "/member/list":
        list();
        break;
      case "/member/update":
        update();
        break;
      case "/member/delete":
        delete();
        break;
      case "/member/detail":
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
    members.add((Member)in.readObject());
  }

  private void list() throws Exception {
    out.writeUTF("OK");
    out.writeUnshared(members);
  }

  private void update() throws Exception {
    int index = 0;

    Member member = (Member)in.readObject();

    for(Member b : members) {
      if (b.getNo() == member.getNo()) {
        members.set(index, member);
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

    for (Member b : members) {
      if (b.getNo() == num) {
        members.remove(index);
        out.writeUTF("해당 번호의 게시물 삭제 완료");
        return;
      }
      index++;
    }
    out.writeUTF("해당 번호가 없습니다.");
  }

  private void detail() throws Exception {
    int num = in.readInt();

    for (Member b : members) {
      if (b.getNo() == num) {
        out.writeUTF("OK");
        out.writeObject(b);
        return;
      }
    }
    out.writeUTF("FAIL");
  }
}
