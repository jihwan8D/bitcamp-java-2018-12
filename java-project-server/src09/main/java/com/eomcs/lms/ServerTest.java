package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerTest {

  static ObjectOutputStream out;
  static ObjectInputStream in;

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음.");

      ServerTest.out = out;
      ServerTest.in = in;

     // MemberTest t1 = new MemberTest(out, in);
     // t1.test();
      // 위의 코드를 아래처럼 바꿀줄 알아야됨 
      new MemberTest(out, in).test(); // test()를 한번만 호출하기에 이렇게 하면 됨
      System.out.println("----------------------------------------------------------------");
      new LessonTest(out, in).test();
      System.out.println("----------------------------------------------------------------");
      new BoardTest(out, in).test();
      System.out.println("----------------------------------------------------------------");
      quit();



    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와 연결을 끊었음.");
  } // main

  static void quit() throws Exception {
    out.writeUTF("quit"); out.flush();
    System.out.println(in.readUTF());
  }
}
