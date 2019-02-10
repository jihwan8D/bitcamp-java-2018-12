package jihwan_practice.network;

import java.net.Socket;

public class Client1 {

  public static void main(String[] args) throws Exception {
    Socket socket = new Socket("localhost", 8888);
    System.out.println("서버와 연결되었습니다.");
    
    socket.close();
  }

}
