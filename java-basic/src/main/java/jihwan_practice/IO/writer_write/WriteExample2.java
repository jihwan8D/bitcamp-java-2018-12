package jihwan_practice.IO.writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample2 {

  public static void main(String[] args) throws Exception {
    Writer fw = new FileWriter("C:/Users/dlsgh/test3.txt");
    
    String data = "이것이 자바다";
    fw.write(data);
    fw.flush();
    fw.close();
    
  }

}
