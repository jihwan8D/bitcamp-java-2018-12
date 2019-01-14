package ch09;

public class Calculator4 {

  int result = 0;

  // 인스턴스 주소를 파라미터로 받지 않고 호출될 때 앞에서 받는 방법
  void plus(int a) {
    // 메서드를 호출할 때 인스턴스 주소를 앞으로 넘겼다.
    // 파라미터 that에 들어 있는 주소로 찾아가서 그 인스턴스의 result 필드를 사용한다.
    this.result += a;
  }

  void minus(int a) {
    // result -= a;
    this.result -= a;
  }

  void multiple(int a) {
    // result *= a;
    this.result *= a;
  }

  void divide(int a) {
    // result /= a;
    this.result /= a;
  }
}