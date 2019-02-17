package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import jihwan_practice.project.server.domain.Lesson;

public class LessonTest {
  ObjectOutputStream out;
  ObjectInputStream in;

  LessonTest(ObjectOutputStream out,  ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }
  public void test() throws Exception {
//    add(new Lesson(1, "JAVA Programming"));
//    add(new Lesson(2, "C Programming"));
//    list();
//    
//    update(new Lesson(1, "C++ Programming"));
//    add(new Lesson(3, "Python Programming"));
//
//    detail(2);
//    delete(3);

    list();
  }
  private void add(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/add");
    out.flush();
    String state = in.readUTF();
    if (!state.equals("OK")) {
      System.out.println("명령을 실행할 수 없습니다.");
      return;
    }
    out.writeObject(lesson);
    out.flush();
  }

  private void list() throws Exception {
    out.writeUTF("/lesson/list");
    out.flush();
    String state = in.readUTF();

    if(state.equals("OK")) {
      @SuppressWarnings("unchecked")
      List<Lesson> lessons = (List<Lesson>) in.readObject();
      for(Lesson l : lessons) {
        System.out.println(l);
      }

    } else
      System.out.println("조회 실패");
  }

  private void update(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/update");
    out.writeObject(lesson);
    out.flush();
    System.out.println(in.readUTF());
  }

  private void delete(int num) throws Exception {
    out.writeUTF("/lesson/delete");
    out.writeInt(num);
    out.flush();
    System.out.println(in.readUTF());
  }

  private void detail(int num) throws Exception {
    out.writeUTF("/lesson/detail");
    out.writeInt(num);
    out.flush();

    String status = in.readUTF();
    if(!status.equals("OK")) {
      System.out.println("해당 게시물 찾지 못함");
    } else {
      System.out.println((Lesson)in.readObject());
    }
  }
}
