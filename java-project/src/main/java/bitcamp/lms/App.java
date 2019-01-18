package bitcamp.lms;

import java.util.Scanner;
import java.sql.Date;

public class App {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int index = 10;
    int[] no = new int[index];
    String[] title = new String[index];
    String[] contents = new String[index];
    Date[] startDate = new Date[index];
    Date[] endDate = new Date[index];
    int[] totalHours = new int[index];
    int[] dayHours = new int[index];

    String input;
    int i = 0;
    
    int[] arr = new int[index];

    while(true) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("수업명? ");
      title[i] = keyboard.nextLine();

      System.out.print("설명? ");
      contents[i] = keyboard.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboard.nextLine());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboard.nextLine());

      System.out.print("총수업시간? ");
      totalHours[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("일수업시간? ");
      dayHours[i] = Integer.parseInt(keyboard.nextLine());

      System.out.println("계속 입력 하시겠니까?");
      input = keyboard.nextLine();

      i++;
   
      if(input.equals("n")) {

        break;
      } else if(input.equals("y")) {

        continue;  
      }
    }
    keyboard.close();
    for(int j = 0; j<i; j++) {
      System.out.printf("%d, %s, %s~%s,%d\n", no[j], title[j], startDate[j], endDate[j], totalHours[j]); 
     }
  }
}