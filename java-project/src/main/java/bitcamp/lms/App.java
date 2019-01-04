package bitcamp.lms;

public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("번호? ");    
    int num = keyboard.nextInt();

    System.out.print("수업명? ");
    String cla = keyboard.next();

    System.out.print("수업내용? ");
    String cont = keyboard.next();

    System.out.print("시작일? ");
    String staD = keyboard.next();

    System.out.print("종료일? ");
    String finD = keyboard.next();

    System.out.print("총수업시간? ");
    int time = keyboard.nextInt();
    
    System.out.print("총수업시간? ");
    int time2 = keyboard.nextInt();
    keyboard.close();
    /////////////////////////////////////////////////////////
    System.out.println();
    /////////////////////////////////////////////////////////

    System.out.printf("번호? %d\n", num);
    System.out.printf("수업명? %s\n", cla);
    System.out.printf("수업내용? %s\n", cont);
    System.out.printf("시작일? %s\n", staD);
    System.out.printf("종료일? %s\n", finD);
    System.out.printf("총수업시간? %d\n", time);
    System.out.printf("일수업시간? %d\n", time2);
  }
}
