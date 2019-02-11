// 계산기 서버 만들기
package ch23.c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
  public static void main(String[] args) {
    int result = 0;
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {


      try (
          Socket socket = serverSocket.accept();

          PrintWriter out = new PrintWriter(socket.getOutputStream());
          // 소켓에 연결되있는 네트워크 데이터를 읽어오는 함수
          DataOutputStream out2 = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
          DataInputStream in = new DataInputStream(new BufferedInputStream((socket.getInputStream())))) {

        out2.writeUTF("계산기 서버에 오신 걸 환영합니다.");
        out2.writeUTF("계산식을 입력하세요!");
        out2.writeUTF("예) 23 + 7");
        out2.flush();
        while(true) {
          
          int request1 = in.readInt();
          String request3 = in.readUTF();
          int request2 = in.readInt();
          switch (request3) {
            case "+": result = plus(request1, request2); break;
            case "-": result = minus(request1, request2); break;
            case "*": result = multiple(request1, request2); break;
            case "/": result = divide(request1, request2); break;
            default:
              System.out.println(request3 + " 연산자를 지원하지 않습니다.");
              return; // main() 메서드를 그만 실행하고 나간다. 즉 JVM 종료!
          }
          System.out.println("결과는 " + result + " 입니다.");

          out.write(result); //클라이언트로 보냄
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
