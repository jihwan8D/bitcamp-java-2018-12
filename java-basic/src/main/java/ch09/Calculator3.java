package ch09;

public class Calculator3 {

  int result = 0; // 인스턴스 필드 = 논스태틱 필드

  void plus(int a) {
    result += a;
  }

  void minus(int a) {
    result -= a;
  }

  void multiple(int a) {
    result *= a;
  }

  void divide(int a) {
    result /= a;
  }
}