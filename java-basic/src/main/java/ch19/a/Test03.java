// 중첩 클래스와 접근 제
package ch19.a;

public class Test03 {

 private static class A1 {}
 static class A2 {}
 protected static class A3 {}
 public static class A4 {}
 
  
  private class B1 {}
  class B2 {}
  protected class B3 {}
  public class B4 {}
  
  
  public static void main(String[] args) {
    class C1{}
    //private class C2{}
  }

}







