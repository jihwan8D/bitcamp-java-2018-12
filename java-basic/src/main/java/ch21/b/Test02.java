// 예외 처리하기 - catch 블록
package ch21.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    System.out.print("파일명을 입력하세요: ");
    String input = keyboard.nextLine();

    try {
      File file = new File(input); // NullPointException

      FileInputStream in = new FileInputStream(file); // FileNotFoundException

      int b = in.read(); // IOException

      in.close(); // IOException
      System.out.println("실행 완료");
    } catch(IOException e) {
      // try 블록에서 발생한 예외 정보를 받으려면 catch 블록에 해당 값을 받을 파라미터를 선언해야 한다.
      System.out.println(e.toString());
    } 
    keyboard.close();
  }
}
