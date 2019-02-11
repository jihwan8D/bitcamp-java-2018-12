// 계산기 서버 만들기
package ch23.c;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer2 {
  public static void main(String[] args) {
  
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while(true) {
        try (
            Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream()); 
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                                                                  // ㄴ 바이너리 스트림과 캐릭터 스트림은 연결해줌

          String[] input = in.readLine().split(" ");

          int a = Integer.parseInt(input[0]);
          String op = input[1];
          int b = Integer.parseInt(input[2]);
          int result = 0;
          switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            case "%": result = a % b; break;
            default :
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }
          out.printf("결과는 %d 입니다.\n", result);
          out.flush();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
  public static int plus(int a, int b) {
    return a + b;
  }
  public static int minus(int a, int b) {
    return a - b;
  }
  public static int multiple(int a, int b) {
    return a * b;
  }
  public static int divide(int a, int b) {
    return a / b;
  }
}
