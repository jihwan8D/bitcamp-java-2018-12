package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    int[] arr1 = new int[1000];
    String[] arr2 = new String[1000];
    String[] arr3 = new String[1000];
    String[] arr4 = new String[1000];
    String[] arr5 = new String[1000];
    int[] arr6 = new int[1000];
    int i = 0;
    Date registeredDate = new Date(System.currentTimeMillis());
    
    while(true) {
      System.out.print("번호? ");
      int num = kbd.nextInt();
      System.out.print("이름? ");
      String className = kbd.next();
      System.out.print("이메일? ");
      String classContent = kbd.next();
      System.out.print("암호? ");
      String start = kbd.next();
      System.out.print("사진? ");
      String end = kbd.next();
      System.out.print("전화? ");
      int totalT = kbd.nextInt();

      arr1[i] = num;
      arr2[i] = className;
      arr3[i] = classContent;
      arr4[i] = start;
      arr5[i] = end;
      arr6[i] = totalT;
      i++;

      System.out.println();
      System.out.println("계속 입력하시겠습니다? (Y/n)");
      
      String yn = kbd.next();
      System.out.println();

      if(!yn.equals("y") && !yn.equals("Y")) {
        for(int j = 0; j<i; j++) {
          System.out.println("번호? " + arr1[j]);
          System.out.println("이름? " + arr2[j]);
          System.out.println("이메일? " + arr3[j]);
          System.out.println("암호? " + arr4[j]);
          System.out.println("사진? " + arr5[j]);
          System.out.println("전화? " + arr6[j]);
          System.out.println();
        }
        for(int j = 0; j<i; j++) {
          System.out.printf("%d, %s, %s  %s, %s\n", arr1[j], arr2[j], arr3[j], arr6[j], registeredDate);
        }
        break;
      } else if (yn.equals("y")||yn.equals("Y")) {
        continue;
      } 
    }
    kbd.close();
  }
}