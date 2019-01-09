// 배열변수 메인변수 통일시키기 와일문 조건 수정하기 y Y 입력수정하기 7
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
      System.out.printf("%d, %-20s, %s ~ %s, %4d\n", arr1[count], arr2[count], arr4[count], arr5[count], arr6[count]);
      count++;
    }
  }
}