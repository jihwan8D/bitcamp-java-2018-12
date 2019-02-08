// 계산기 클라이언트 만들기 : 최소 +, -, *, /, % 연산자는 지원한다.
package ch23.c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
실행 예:
- 클라이언트가 계산기 서버에 접속한 후 

계산기 서버에 오신 걸 환영합니다! <== 서버의 응답
계산식을 입력하세요! <== 서버의 응답
예) 23 + 7 <== 서버의 응답
> 23 + 7 <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
결과는 30 입니다. <== 서버의 응답
> 23 ^ 7 <== 사용자의 입력 '>'문자는 클라이언트에서 출력한다.
^ 연산자를 지원하지 않습니다. <== 서버의 응답
> ok + yes <== 사용자의 입력 '>'문자는 클라이언트에서 출력한다.
식의 형식이 잘못되었습니다. <== 서버의 응답
> quit <== 사용자의 입력 '>'문자는 클라이언트에서 출력한다.
안녕히 가세요! <== 서버의 응답
 */
public class CalculatorClient {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    try (Socket socket = new Socket("localhost", 8888);

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream((socket.getOutputStream())));
        // 소켓에 연결되있는 네트워크 데이터를 읽어오는 함수
        Scanner in = new Scanner(socket.getInputStream())) {

      System.out.println(in.nextLine());
      System.out.println(in.nextLine());
      System.out.println(in.nextLine());
      
      System.out.print("> ");
      int num1 = keyboard.nextInt();
      String aa = keyboard.next();
      int num2 = keyboard.nextInt();
      out.write(num1);
      out.writeChars(aa);
      out.write(num2);
      out.flush();
      int response = in.nextInt(); //서버로부터 읽어온거
      System.out.println(response);

    } catch (Exception e) {
      ;
      System.out.println(e);
    }
  }

}
