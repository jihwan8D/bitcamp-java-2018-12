package bitcamp.lms;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    
    final int LENGTH = 1000;
    int[] num = new int[LENGTH];
    String[] className = new String[LENGTH];
    String[] classContent = new String[LENGTH];
    String[] start = new String[LENGTH];
    String[] end = new String[LENGTH];
    int[] totalT = new int[LENGTH];
    int[] dayT = new int[LENGTH];
    int i = 0;

    while(i<LENGTH) {
      System.out.print("번호? ");
      num[i] = kbd.nextInt();
      System.out.print("수업명? ");
      className[i] = kbd.next();
      System.out.print("수업내용? ");
      classContent[i] = kbd.next();
      System.out.print("시작일? ");
      start[i] = kbd.next();
      System.out.print("종료일? ");
      end[i] = kbd.next();
      System.out.print("총수업시간? ");
      totalT[i] = kbd.nextInt();
      System.out.print("일수업시간? ");
      dayT[i] = kbd.nextInt();

      i++;

      System.out.println();
      System.out.print("계속 입력하시겠습니다? (Y/n) ");
      String yn = kbd.next();

      System.out.println();

      if(!yn.equals("y") && !yn.equals("Y") && !yn.equals("")) { //if(yn.equalsIgnoreCase("y")); 대소문자 구분안함
        break;
      } else //if (yn.equals("y")||yn.equals("Y")) 
      {
        continue;
      } 
    }
    kbd.close();
    int count = 0;
    while(count < i) {
      System.out.printf("%d, %-20s, %s ~ %s, %4d\n", num[count], className[count], start[count], end[count], totalT[count]);
      count++;
    }
  }
}