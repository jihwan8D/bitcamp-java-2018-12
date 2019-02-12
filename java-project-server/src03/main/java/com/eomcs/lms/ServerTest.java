// 2단계: 서버 테스트
package com.eomcs.lms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {
      
      System.out.println("서버와 연결되었음.");
      
      out.println("Hello");
      out.flush();
      
      System.out.println(in.nextLine());
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와 연결을 끊었음.");
  } 
}
