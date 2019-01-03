package ch02;

public class Test02 {
  public static void main(String[] args) {
    //20억을 4바이트 리터럴로 출력하라.
    System.out.println(2000000000);
    //20억을 8바이트 리터럴로 출력하라.
    System.out.println(2000000000L);
    //30억을 8바이트 리터럴로 출력하라.
    System.out.println(3000000000L);
    //30억을 4바이트 리터럴로 출력하라.
    //System.out.println(3000000000); 컴파일 에러 왜냐하면 int는 21억까지만 표현 가능하기 때문에
  }
}