package jihwan_practice.network;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server1 {

  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("연결을 기다리는 중...");
    
    Scanner k = new Scanner(System.in);
    k.nextLine();
    
    k.close();
    serverSocket.close();
    
    
  }

}
