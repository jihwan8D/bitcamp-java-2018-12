// 11단계: AbstractService 상속 받기
package com.eomcs.lms.service;

import com.eomcs.lms.domain.Lesson;

//클라이언트의 요청을 처리하는 클래스라는 의미로
//클래스명을 *Service로 변경한다.
public class LessonService extends AbstractService<Lesson> {

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
    list.add((Lesson)in.readObject());
    out.writeUTF("OK");
  }

  private void list() throws Exception {
    out.writeUTF("OK");
    out.flush();
    out.writeUTF("OK");
    out.writeObject(list);
  }

  private void detail() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    for(Lesson l : list) {
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
    for(Lesson l : list) {
      if(l.getNo() == memeber.getNo()) {
        list.set(index, memeber);
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
    for(Lesson l : list) {
      if(l.getNo() == no) {
        list.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    }
    out.writeUTF("FAIL");
  }
}
