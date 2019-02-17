package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import jihwan_practice.project.server.domain.Member;

public class MemberTest {
  ObjectOutputStream out;
  ObjectInputStream in;

  MemberTest(ObjectOutputStream out,  ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }
  public void test() throws Exception {
//    add(new Member(1, "홍길동"));
//    add(new Member(2, "임꺽정"));
//    list();
//
//    update(new Member(1, "xxxxxxxx홍길동xxxxxx"));
//    add(new Member(3, "게시글 3"));
//
//    detail(2);
//    delete(3);

    list();
  }
  private void add(Member member) throws Exception {
    out.writeUTF("/member/add");
    out.flush();
    String state = in.readUTF();
    if (!state.equals("OK")) {
      System.out.println("명령을 실행할 수 없습니다.");
      return;
    }
    out.writeObject(member);
    out.flush();
  }

  private void list() throws Exception {
    out.writeUTF("/member/list");
    out.flush();
    String state = in.readUTF();

    if(state.equals("OK")) {
      @SuppressWarnings("unchecked")
      List<Member> members = (List<Member>) in.readObject();
      for(Member l : members) {
        System.out.println(l);
      }

    } else
      System.out.println("조회 실패");
  }

  private void update(Member member) throws Exception {
    out.writeUTF("/member/update");
    out.writeObject(member);
    out.flush();
    System.out.println(in.readUTF());
  }

  private void delete(int num) throws Exception {
    out.writeUTF("/member/delete");
    out.writeInt(num);
    out.flush();
    System.out.println(in.readUTF());
  }

  private void detail(int num) throws Exception {
    out.writeUTF("/member/detail");
    out.writeInt(num);
    out.flush();

    String status = in.readUTF();
    if(!status.equals("OK")) {
      System.out.println("해당 게시물 찾지 못함");
    } else {
      System.out.println((Member)in.readObject());
    }
  }
}
