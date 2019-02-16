package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) {

    try (ServerSocket ss = new ServerSocket(8888)){
      System.out.println("서버 시작");

      while (true) {
        try (Socket s = ss.accept();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())) {
          System.out.println("클라이언트와 연결됨");

          System.out.println(in.readUTF()); 

          out.writeUTF("서버에서 보낸 메시지");
          out.flush();

        } catch (Exception e) {
          e.printStackTrace();        
        }
        System.out.println("클라이언트와의 연결을 끊었음.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

