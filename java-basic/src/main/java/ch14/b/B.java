package ch14.b;

public class B extends A{

  // 오버라이딩 규칙
  // => 메서드 시그너처를 똑같게 해야 한다.
  //@Override void m1(int xx) {} // Ok!

  // => 리턴 타입이 다르면 안된다.
  //@Override int m1() {int a} //컴파일 오류

  // => 파라미터의 타입이 다르면 안된다.
  //@Override void m1(long a) {}

  // => 파라미터의 개수가 다르면 안된다.
  //@Override void m1(int a, int b) {}

  // => 접근 범위를 축소하는 것은 안된다.
  //@Override private void m1(int xx) {}

  //=> 접근 범위를 확대하는 것은 안된다.
  //@Override protected void m1(int xx) {}
  @Override public void m1(int xx) {}

  //=> 접근 범위를 축소하는 것은 안된다.
  //@Override protected void m2(String a, int b) {}
  @Override public void m2(String a, int b) {}
}