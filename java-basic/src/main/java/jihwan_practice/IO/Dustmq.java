package jihwan_practice.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Dustmq {

  public static void main(String[] args) {

    try(OutputStream os = new FileOutputStream("C:/Users/dlsgh/test2.txt");
        InputStream is = new FileInputStream("C:/Users/dlsgh/test2.txt")) {

      byte[] data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
      os.write(data);
      System.out.println("출력완료 \n");
      
      int a;
      byte[] readByte = new byte[10];
      
      while((a = is.read(readByte)) != -1){
        System.out.println(a);
      }
      
    } catch(Exception e) {
      e.printStackTrace();
    }

  }

}
