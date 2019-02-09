package jihwan_practice.IO.reader_read;

import java.io.Reader;
import java.io.FileReader;

public class ReadExample3 {

  public static void main(String[] args) {
    try(Reader reader = new FileReader("C:/Users/dlsgh/test2.txt")){

      int readCharNo;
      char[] readChar = new char[2];
      readCharNo = reader.read(readChar, 0, 2);
      
      for(int i = 0; i < readChar.length; i++) {
        System.out.println(readChar[i]);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
