package jihwan_practice.project.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerTest {

  public static void main(String[] args) {
    
    try (Socket s = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream())) {
      
      System.out.println("서버와 연결됨");
      
      out.writeUTF("Hello");
      out.flush();
      System.out.println(in.readUTF());
    } catch(Exception e) {
      
    }
    System.out.println("서버와의 연결을 끊었음.");
  }
}
