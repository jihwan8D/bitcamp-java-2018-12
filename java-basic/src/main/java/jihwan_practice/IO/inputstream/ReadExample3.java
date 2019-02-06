package jihwan_practice.IO.inputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample3 {

  public static void main(String[] args) throws Exception {
    InputStream is = new FileInputStream("C:/Users/dlsgh/test.txt");
    
    byte[] readBytes = new byte[10];
    
    is.read(readBytes, 4, 2 );
    
    for(int i = 0; i < readBytes.length; i++) {
      System.out.print(readBytes[i] + " ");
    }
    is.close();
  }

}
