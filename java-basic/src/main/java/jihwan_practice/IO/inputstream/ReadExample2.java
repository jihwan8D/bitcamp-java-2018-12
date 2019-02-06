package jihwan_practice.IO.inputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {

  public static void main(String[] args) throws Exception{
    InputStream is = new FileInputStream("C:/Users/dlsgh/test.txt");
    
    int readByte;
    
    byte[] readBytes = new byte[3];
    
    String data;
    
    while((readByte = is.read(readBytes)) != -1) {
      //System.out.println(readByte);
      data = new String(readBytes, 0, readByte);
      System.out.print(data);
    }
    is.close();
  }
}
