package bitcamp.lms;
import java.util.Scanner;


public class App {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    
    final int LENGTH = 1000;
    
    //Lesson 인스턴스의 주소를 담을 레퍼런스를 먼저 100개 생성한다.
    Lesson[] myLesson = new Lesson[LENGTH];
                                 //래퍼런스 배열
    int size =0;
    
/*    for(int j=0; j<LENGTH; j++) {  //이렇게 해도 되지만 메모리낭비를하게 된다.. 쓰지도 않는 방을 만들어놔서..
      myLesson[j] = new Lesson();
    }       */
    while(size < LENGTH) {
      Lesson myLessons = new Lesson();
      
      System.out.print("번호? ");
      myLessons.num = kbd.nextInt();
      
      System.out.print("수업명? ");
      myLessons.className = kbd.next();
      
      System.out.print("수업내용? ");
      myLessons.classContent = kbd.next();
      
      System.out.print("시작일? ");
      myLessons.start = kbd.next();
      
      System.out.print("종료일? ");
      myLessons.end = kbd.next();
      
      System.out.print("총수업시간? ");
      myLessons.totalT = kbd.nextInt();
      
      System.out.print("일수업시간? ");
      myLessons.dayT = kbd.nextInt();
      
      myLesson[size++] = myLessons;  //myLessons 주소를 myLesson에 저장
      
      //i++;

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
   
    for(int i = 0; i<size; i++) {
      System.out.printf("%d, %-20s, %s ~ %s, %4d\n",  
          myLesson[i].num,  myLesson[i].className,  myLesson[i].start, 
          myLesson[i].end,  myLesson[i].totalT);
    }
  }
}