package jihwan_practice.project.server.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import jihwan_practice.project.server.domain.Lesson;

public class LessonService {
  public ObjectInputStream in;
  public ObjectOutputStream out;
  public ArrayList<Lesson> lessons = new ArrayList<>();
  String request;
  String fileName;
  
  public void inOut(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }
  
  @SuppressWarnings("unchecked")
  public void loadDate(String fileName) {
    this.fileName = fileName;
    
    try(ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream(this.fileName)))) {
      
      lessons = (ArrayList<Lesson>) in.readObject();
      
    } catch(Exception e) {
      throw new RuntimeException("수업 데이터 파일 로딩 오류!", e);
    }
  }
  
  public void saveDate() throws Exception {
    try(ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(this.fileName)))) {
      
      out.writeObject(lessons);
      
    } catch(Exception e) {
      throw new Exception("수업 데이터의 파일 저장 오류!", e);
    }
  }
  
  public void command(String request) throws Exception {
    switch (request) {
      case "/lesson/add":
        add();
        break;
      case "/lesson/list":
        list();
        break;
      case "/lesson/update":
        update();
        break;
      case "/lesson/delete":
        delete();
        break;
      case "/lesson/detail":
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
    lessons.add((Lesson)in.readObject());
  }

  private void list() throws Exception {
    out.writeUTF("OK");
    out.writeUnshared(lessons);
  }

  private void update() throws Exception {
    int index = 0;

    Lesson lesson = (Lesson)in.readObject();

    for(Lesson b : lessons) {
      if (b.getNo() == lesson.getNo()) {
        lessons.set(index, lesson);
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

    for (Lesson b : lessons) {
      if (b.getNo() == num) {
        lessons.remove(index);
        out.writeUTF("해당 번호의 게시물 삭제 완료");
        return;
      }
      index++;
    }
    out.writeUTF("해당 번호가 없습니다.");
  }

  private void detail() throws Exception {
    int num = in.readInt();

    for (Lesson b : lessons) {
      if (b.getNo() == num) {
        out.writeUTF("OK");
        out.writeObject(b);
        return;
      }
    }
    out.writeUTF("FAIL");
  }
}
