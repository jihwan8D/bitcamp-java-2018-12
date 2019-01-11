package bitcamp.lms;
import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    final int LENGTH = 1000;
    Date registeredDate = new Date(System.currentTimeMillis());
    Member myMem[] = new Member[LENGTH];
    Scanner kbd = new Scanner(System.in);
    
    int i = 0;

    for(int j = 0; j < LENGTH; j++) {
      myMem[j] = new Member();
    }
    while(i < LENGTH) {
      System.out.print("번호? ");
      myMem[i].num = kbd.nextInt();
      System.out.print("이름? ");
      myMem[i].name = kbd.next();
      System.out.print("이메일? ");
      myMem[i].email = kbd.next();
      System.out.print("암호? ");
      myMem[i].pw = kbd.next();
      System.out.print("사진? ");
      myMem[i].pho = kbd.next();
      System.out.print("전화? ");
      myMem[i].phone = kbd.next();

      i++;

      System.out.println();
      System.out.println("계속 입력하시겠습니다? (Y/n)");
      String yn = kbd.next();
      System.out.println();

      if(!yn.equals("y") && !yn.equals("Y")) {
        break;
      } else{
        continue;
      } 
    }
    kbd.close();
    for(int j = 0; j<i; j++) {
      System.out.printf("%d, %s, %s  %s, %s\n", 
          myMem[j].num, myMem[j].name, myMem[j].email, myMem[j].phone, registeredDate);
    }
  }
}