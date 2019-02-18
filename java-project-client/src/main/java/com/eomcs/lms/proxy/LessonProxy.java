package com.eomcs.lms.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonProxy implements LessonDao {

  String serverAddr;
  int port;
  String rootPath;

  public LessonProxy(String serverAddr, int port, String rootPath) {
    
    this.serverAddr = serverAddr;
    this.port = port;
    this.rootPath = rootPath;
  }

  @SuppressWarnings("unchecked")
  public List<Lesson> findAll() {
    
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF(rootPath + "/list"); 
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버의 데이터 목록 가져오기 실패!");

      return (List<Lesson>) in.readObject();
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Lesson lesson) {
    
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF(rootPath + "/add"); 
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(lesson);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버의 데이터 저장 실패!");
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Lesson findByNo(int no) {
    
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF(rootPath + "/detail");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버의 데이터 가져오기 실패!");

      return (Lesson) in.readObject();
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Lesson lesson) {
    
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF(rootPath + "/update");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(lesson);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) 
        throw new Exception("서버의 데이터 데이터 변경 실패!");
     
      return 1;
    
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF(rootPath + "/delete");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버의 데이터 삭제 실패!");
      
      return 1;
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}









