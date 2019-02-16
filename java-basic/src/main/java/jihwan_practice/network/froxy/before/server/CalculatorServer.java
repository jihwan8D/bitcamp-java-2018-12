package jihwan_practice.network.froxy.before.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {


  public static void main(String[] args) {

    Calculator c = new Calculator();

    try (ServerSocket ss = new ServerSocket(8888);) {
      System.out.println("서버 실행중");

      while(true) {
        System.out.println("클라이언트 연결대기");
        try(Socket s = ss.accept();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())) {
          System.out.println("클라이언트 연결 됨");
          
          String nk = in.readUTF();
          if (nk.equalsIgnoreCase("quit")) {
            System.out.println("서버 종료합니다.");
            break;
          }
          int num1 = in.readInt();
          String op = in.readUTF();
          int num2 = in.readInt();



          switch (op) {
            case  "+" : 
              out.writeInt(c.plus(num1, num2));
              break;
            case  "-" : 
              out.writeInt(c.minus(num1, num2));
              break;
          }
          out.flush();


        } catch (Exception e) {
          e.printStackTrace();
        }
      }


    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
