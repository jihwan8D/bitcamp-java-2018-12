package bitcamp.lms;

public class App3 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    java.util.Date today = new java.util.Date();
    System.out.print("번호? ");
    int num = keyboard.nextInt();
    System.out.print("내용? ");
    String cont = keyboard.next();
    System.out.println();
    System.out.printf("번호: %d\n", num);
    System.out.printf("내용: %s\n", cont);
    keyboard.close();
    System.out.println();
    System.out.printf("작성일: %tY-%1$tm-%1$td\n", today);
    System.out.println("조회수: 0");


  }
}
