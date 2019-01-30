// try-with-resources 문법 : 문법 확인
package ch21.f;

public class Test03 {

  static class MyResource1 {
    public void close() {
      System.out.println("MyResource1.close()");
    }
  }

  static class MyResource2 implements AutoCloseable {
    @Override
    public void close() {
      System.out.println("MyResource2.close()");

    }
    public int divide(int a , int b) {
      return a / b;
    }
  }


  public static void main(String[] args) {

    try(

        MyResource2 r2 = new MyResource2();
        ) {
      System.out.println(r2.divide(10,2));
      System.out.println(r2.divide(10,0));
    } catch (Exception e) {
      System.out.println("예외 발생");
    }


  }


}






