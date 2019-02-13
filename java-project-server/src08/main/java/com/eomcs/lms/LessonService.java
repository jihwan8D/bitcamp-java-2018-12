// 8단계: 클라이언트에서 요청을 처리하는 클래스에 대해 리팩토링 수행
package com.eomcs.lms;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.eomcs.lms.domain.Lesson;

//클라이언트의 요청을 처리하는 클래스라는 의미로
//클래스명을 *Service로 변경한다.
public class LessonService {

  private ArrayList<Lesson> lessons = new ArrayList<>();

  private ObjectInputStream in;
  private ObjectOutputStream out;

  public LessonService(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  public void execute(String request) throws Exception {

    switch(request) {
      case "/lesson/add":
        add();
        break;
      case "/lesson/list":
        list();
        break;
      case "/lesson/detail":
        detail();
        break;
      case "/lesson/update":
        update();
        break;
      case "/lesson/delete":
        delete();
        break;
      default:
        out.writeUTF("FAIL");
    }
    out.flush();
  }

  private void add() throws Exception {
    out.writeUTF("OK");
    out.flush();
    lessons.add((Lesson)in.readObject());
    out.writeUTF("OK");
  }

  private void list() throws Exception {
    out.writeUTF("OK");
    out.flush();
    out.writeUTF("OK");
    out.writeObject(lessons);
  }

  private void detail() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    for(Lesson l : lessons) {
      if(l.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(l);
        return;
      }
    }
    out.writeUTF("FAIL");
  }

  private void update() throws Exception {
    out.writeUTF("OK");
    out.flush();
    Lesson memeber = (Lesson) in.readObject();

    int index = 0;
    for(Lesson l : lessons) {
      if(l.getNo() == memeber.getNo()) {
        lessons.set(index, memeber);
        out.writeUTF("OK");
        out.writeObject(l);
        return;
      }
      index++;
    }
    out.writeUTF("FAIL");
  }

  private void delete() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    int index = 0;
    for(Lesson l : lessons) {
      if(l.getNo() == no) {
        lessons.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    }
    out.writeUTF("FAIL");
  }
}
