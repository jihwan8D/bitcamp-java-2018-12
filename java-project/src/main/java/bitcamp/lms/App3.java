package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    Date registeredDate = new Date(System.currentTimeMillis());

    int[] arr1 = new int[1000];
    String[] arr2 = new String[1000];
    int viewCount = 0;
    int i = 0;

    while(true) {
      System.out.print("번호? ");
      int num = kbd.nextInt();
      System.out.print("수업명? ");
      String className = kbd.next();

      System.out.println();
      System.out.println("계속 입력하시겠습니다? (Y/n)");
      System.out.println();

      arr1[i] = num;
      arr2[i] = className;

      i++;

      String yn = kbd.next();

      if(!yn.equals("y") && !yn.equals("Y")) {
        for(int j = 0; j<i; j++) {
          System.out.println("번호? " + arr1[j]);
          System.out.println("수업명? " + arr2[j]);
          System.out.println();
        }
        for(int j = 0; j<i; j++) {
          System.out.printf("%d, %s, %s %d\n", arr1[j], arr2[j], registeredDate, viewCount);
        }
        break;
      } else if (yn.equals("y")||yn.equals("Y")) {
        continue;
      } 
    }
  }
}