// Stateless 클라이언트 만들기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient_tateless_practice {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    long session = 0;
    
    while (true) {
      System.out.print("> ");
      String input = keyboard.nextLine();
      if (input.equalsIgnoreCase("quit"))
        break;

      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()))) {
        
        System.out.println("서버와 연결됨! 서버에게 계산 작업을 요청함!");
        
        out.println(session);
        out.println(input);
        out.flush();

        session = Long.parseLong(in.readLine());
        System.out.println(session);
        String response = in.readLine();
        System.out.println(response);
        
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("서버와 연결 끊음!");
      
    } // while
    
    keyboard.close();
  }
}











