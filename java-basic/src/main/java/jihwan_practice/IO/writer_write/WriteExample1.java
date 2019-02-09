package jihwan_practice.IO.writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample1 {

  public static void main(String[] args) throws Exception {
    Writer fw = new FileWriter("C:/Users/dlsgh/test3.txt");
    char[] a = "이것이자바다".toCharArray();
    fw.write(a, 1, 2);
    fw.flush();
    fw.close();
  }

}
