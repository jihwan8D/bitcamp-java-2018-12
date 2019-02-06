package jihwan_practice.IO.outputstream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample1 {

  public static void main(String[] args) throws Exception {
    OutputStream os = new FileOutputStream("C:/Users/dlsgh/test2.txt");
    
    byte[] data = "ABC".getBytes();
    
    for(int i = 0; i < data.length; i++) {
      os.write(data[i]);
    }
    os.flush();
    os.close();
  }

}
