package jihwan_practice.IO.reader_read;

import java.io.Reader;
import java.io.FileReader;

public class ReadExample2 {

  public static void main(String[] args) {
    try(Reader reader = new FileReader("C:/Users/dlsgh/test2.txt")){
      int readerDataNo;
      char[] readChar = new char[6];
      String data = null;

      while((readerDataNo = reader.read(readChar)) != -1) {
        data += new String(readChar, 0, readerDataNo);
      }
      System.out.println(data);
      reader.close();

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
