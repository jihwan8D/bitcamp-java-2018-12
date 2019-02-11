package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8888)){
      System.out.println("서버 실행중...");

      while(true) {
        try(Socket socket = serverSocket.accept(); 
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream())) {
          try {
            String[] input = in.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            String op = input[1];
            int b = Integer.parseInt(input[2]);

            int result = 0;

            switch(op) {
              case "+" : result = a + b; break;
              case "-" : result = a - b; break;
              case "*" : result = a * b; break;
              case "/" : result = a / b; break;
              case "%" : result = a % b; break;
              default : 
                out.println("지원하지 않는 연산자 입니다.");
                out.flush();
                continue;
            }
            out.printf("결과는 %d 입니다.\n", result);
            out.flush();
          } catch(Exception e) {
            out.println("식의 형식이 잘못되었습니다.");
          }

        } catch(Exception e) {
          e.printStackTrace();
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
