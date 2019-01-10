package bitcamp.lms;
import java.util.Scanner;


public class App {
  public static void main(String[] args) {
    final int LENGTH = 1000;
    Lesson[] myLesson = new Lesson[LENGTH];
    Scanner kbd = new Scanner(System.in);
    
    int i =0;
    
    for(int j=0; j<LENGTH; j++) {
      myLesson[j] = new Lesson();
    }
   
    while(i < LENGTH) {
      System.out.print("번호? ");
      myLesson[i].num = kbd.nextInt();
      System.out.print("수업명? ");
      myLesson[i].className = kbd.next();
      System.out.print("수업내용? ");
      myLesson[i].classContent = kbd.next();
      System.out.print("시작일? ");
      myLesson[i].start = kbd.next();
      System.out.print("종료일? ");
      myLesson[i].end = kbd.next();
      System.out.print("총수업시간? ");
      myLesson[i].totalT = kbd.nextInt();
      System.out.print("일수업시간? ");
      myLesson[i].dayT = kbd.nextInt();

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
   
    for(count=0; count<i; count++) {
      System.out.printf("%d, %-20s, %s ~ %s, %4d\n",  
          myLesson[count].num,  myLesson[count].className,  myLesson[count].start,  myLesson[count].end,  myLesson[count].totalT);
    }
  }
}