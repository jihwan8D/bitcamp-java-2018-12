// 14단계: DAO에 프록시 패턴 적용하기
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonSkel;
import com.eomcs.lms.service.MemberService;
import com.eomcs.lms.service.Service;

// 멀티 스레드 적용
// => 클라이언트 요청을 별도의 스레드에서 처리한다.
// => 작업
// 1) 클라이언트의 요청 작업을 처리하는 코드를 별도의 스레드 클래스로 분리한다.
//    => 예)  RequestProcessorThread 클래스 정의
// 2) 클라이언트가 연결되었을 때 스레드에게 실행을 위임한다.
//
//
public class ServerApp {

  static BoardDaoImpl boardDao = null;
  static MemberDaoImpl memberDao = null;
  static LessonDaoImpl lessonDao = null;

  static HashMap<String, Service> serviceMap;
  static Set<String> servicekeySet;

  public static void main(String[] args) {

    try {
      boardDao = new BoardDaoImpl("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    try {
      memberDao = new MemberDaoImpl("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    try {
      lessonDao = new LessonDaoImpl("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardDaoSkel(boardDao));
    serviceMap.put("/member/", new MemberService(memberDao));
    serviceMap.put("/lesson/", new LessonSkel(lessonDao));
    //LessonService lessonService = new LessonService(lessonDao);

    servicekeySet = serviceMap.keySet();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      while (true) {
        // 클라이언트 소켓을 꺼낸 후 스레드에게 전달한다.
        // 그리고 스레드를 실행시킨다.
        // start()를 호출하면 스레드가 독립적으로 실행된다.
        // 스레드의 run() 메서드가 호출된다.
        new RequestProcessorThread(serverSocket.accept()).start();
        // 스레드를 시작시킨 후 즉시 리턴한다.
        // 스레드가 작업을 종료할 때까지 기다리지 않는다.
        // 즉 비동기로 동작한다.
      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static class RequestProcessorThread extends Thread {

    Socket socket;

    public RequestProcessorThread(Socket socket) {
      this.socket = socket;
    }

    // 독립적으로 수행할 코드를 run() 메서드에 작성한다.
    @Override
    public void run() {
      try (Socket socket = this.socket;
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

        System.out.println("클라이언트와 연결되었음.");

        String request = in.readUTF();
        System.out.println(request);

        Service service = getService(request);
       
        if (service == null) {
          out.writeUTF("FAIL");
          
        } else {
          service.execute(request, in, out);
        }
        out.flush();

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("클라이언트와의 연결을 끊었음.");
    }
  }

  static Service getService(String request) {
    for (String key : servicekeySet) {
      if (request.startsWith(key)) {
        return serviceMap.get(key);
      }
    }
    return null;
  }
}







