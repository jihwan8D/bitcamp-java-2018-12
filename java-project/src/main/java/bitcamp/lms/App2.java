package bitcamp.lms;

public class App2 {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    System.out.print("번호? ");
    int num = keyboard.nextInt();
    
    System.out.print("이름? ");
    String name = keyboard.next();
    
    System.out.print("이메일? ");
    String email = keyboard.next();
    
    System.out.print("암호? ");
    String pass = keyboard.next();
    
    System.out.print("사진? ");
    String phot = keyboard.next();
    
    System.out.print("전화? ");
    String pN = keyboard.next();
    
    keyboard.close();
    /////////////////////////////////////////////////////////
    System.out.println();
    /////////////////////////////////////////////////////////
    
    System.out.printf("번호? %d\n", num);
    System.out.printf("이름? %s\n", name);
    System.out.printf("이메일? %s\n", email);
    System.out.printf("암호? %s\n", pass);
    System.out.printf("사진? %s\n", phot);
    System.out.printf("전화? %s\n", pN);
    /*
   번호? 1
    이름? 홍길동
    이메일? hong@test.com
    암호? 1111
    사진? hong.png
    전화? 1111-2222
     */
  }
}
