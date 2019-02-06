package jihwan_practice.IO.reader_read;

import java.io.Reader;
import java.io.FileReader;

public class ReadExample1 {

  public static void main(String[] args) throws Exception {
    Reader reader = new FileReader("C:/Users/dlsgh/test3.txt");
    int readerData;
    
    while((readerData = reader.read()) != -1) {
      System.out.println((char)readerData);
    }
    reader.close();
  }
}
