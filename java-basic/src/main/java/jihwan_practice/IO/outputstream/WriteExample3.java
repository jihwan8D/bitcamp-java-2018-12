package jihwan_practice.IO.outputstream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample3 {

  public static void main(String[] args) throws Exception {
    OutputStream os = new FileOutputStream("C:/Users/dlsgh/test2.txt");
    
    byte[] data = "ABCDEF".getBytes();
    
    os.write(data, 2, 3);
    os.flush();
    os.close();
  }

}
