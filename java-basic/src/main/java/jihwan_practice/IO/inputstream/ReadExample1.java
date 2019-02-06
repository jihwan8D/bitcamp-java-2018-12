package jihwan_practice.IO.inputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample1 {

  public static void main(String[] args) throws Exception{
    InputStream is = new FileInputStream("C:/Users/dlsgh/test.txt");

    int readByte;
    
    while((readByte = is.read()) != -1) {
      System.out.println((char)readByte);
    }
    is.close();
  }
}
