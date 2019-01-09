package bitcamp.lms;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    int[] arr1 = new int[1000];
    String[] arr2 = new String[1000];
    String[] arr3 = new String[1000];
    String[] arr4 = new String[1000];
    String[] arr5 = new String[1000];
    int[] arr6 = new int[1000];
    int[] arr7 = new int[1000];
    int i = 0;

    while(true) {
      System.out.print("번호? ");
      int num = kbd.nextInt();
      System.out.print("수업명? ");
      String className = kbd.next();
      System.out.print("수업내용? ");
      String classContent = kbd.next();
      System.out.print("시작일? ");
      String start = kbd.next();
      System.out.print("종료일? ");
      String end = kbd.next();
      System.out.print("총수업시간? ");
      int totalT = kbd.nextInt();
      System.out.print("일수업시간? ");
      int dayT = kbd.nextInt();

      arr1[i] = num;
      arr2[i] = className;
      arr3[i] = classContent;
      arr4[i] = start;
      arr5[i] = end;
      arr6[i] = totalT;
      arr7[i] = dayT;
      i++;

      System.out.println();
      System.out.println("계속 입력하시겠습니다? (Y/n)");

      String yn = kbd.next();
      System.out.println();

      if(!yn.equals("y") && !yn.equals("Y")) {
        for(int j = 0; j<i; j++) {
          System.out.println("번호? " + arr1[j]);
          System.out.println("수업명? " + arr2[j]);
          System.out.println("수업내용? " + arr3[j]);
          System.out.println("시작? " + arr4[j]);
          System.out.println("종료? " + arr5[j]);
          System.out.println("총수업시간? " + arr6[j]);
          System.out.println("일수업시간? " + arr7[j]);
          System.out.println();
        }
        for(int j = 0; j<i; j++) {
          System.out.printf("%d, %s, %s ~ %s, %d\n", arr1[j], arr2[j], arr4[j], arr5[j], arr6[j]);
        }
        break;
      } else //if (yn.equals("y")||yn.equals("Y")) 
          {
            continue;
          } 
    }
    kbd.close();
  }
}