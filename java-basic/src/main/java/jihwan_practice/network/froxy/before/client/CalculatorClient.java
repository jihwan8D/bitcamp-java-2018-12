package jihwan_practice.network.froxy.before.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CalculatorClient {

  public int compute(int a, int b, String op) throws Exception {
    try(Socket s = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream())) {

      out.writeUTF("OK");
      out.writeInt(a);
      out.writeUTF(op);
      out.writeInt(b);
      out.flush();

      return in.readInt();

    }
  }

  public void quit() throws Exception {
    try(Socket s = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream())) {

      out.writeUTF("quit");
      out.flush();
    }
  }

}
