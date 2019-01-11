package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    final int LENGTH = 1000;
    Scanner kbd = new Scanner(System.in);
    Date registeredDate = new Date(System.currentTimeMillis());
    Board[] myBoa = new Board[LENGTH];
    int viewCount = 0;
    
    for(int j = 0; j < LENGTH; j++) {
      myBoa[j] = new Board();
    }
    
    int i = 0;

    while(i < LENGTH) {
      System.out.print("번호? ");
      myBoa[i].num = kbd.nextInt();
      System.out.print("수업명? ");
      myBoa[i].className = kbd.next();

   
      i++;

      System.out.println();
      System.out.println("계속 입력하시겠습니다? (Y/n)");
      System.out.println();

      String yn = kbd.next();

      if(!yn.equals("y") && !yn.equals("Y")) {
     
        for(int j = 0; j<i; j++) {
          System.out.printf("%d, %s, %s %d\n", myBoa[j].num, myBoa[j].className, registeredDate, viewCount);
        }
        break;
      } else if (yn.equals("y")||yn.equals("Y")) {
        continue;
      } 
    }
    kbd.close();
  }
}