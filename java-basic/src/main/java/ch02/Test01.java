package ch02;

public class Test01 {
  public static void main(String[] args) {
    //정수 78을 출력하라
    // => 10진수
    System.out.println(78);
    // => 8진수
    System.out.println(0116);
    // => 16진수
    System.out.println(0x4E);
    // => 2진수
    System.out.println(0b1001110);
    // 2) 부동소수점을 출력하라.
    // => 12.345를 출력
    System.out.println(12.345);
    // => 1.2345 를 12.345로 출력
    System.out.println(0.12345E2);
    // => 0.12345를 12.345로 출력
    System.out.println(123.45E-1);
    // =>123.45를 12.345로 출력
    System.out.println(123.45E-1);
    // 3) 논리값을 출력하라
    // => 참 을 출력하라
    System.out.println(true);
    // => 거짓 을 출력하라
    System.out.println(false);
    // 4) 문자를 출력하라.
    // => 0x61 값을 출력했을 때 a가 보이도록 하라
    System.out.println((char)0x61);
    // => 97 값을 출력했을 때 a가 나오게 하라
    System.out.println((char)97);
    // => 작은 따옴표를 사용하려 a를 출력하라.
    System.out.println('a');
    // 5) 문자열을 출력하라.
    // => Hello라는 문자열을 출력하라.
    System.out.println("Hello");
    // => 안녕하세요 라는 문자열을 출력하라.
    System.out.println("안녕하세요");

  }
}