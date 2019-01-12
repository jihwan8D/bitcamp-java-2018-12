package ch08;

class Calculator2 {
  static int base = 0;
  static double PI = 3.14;
  int left, right;

  public void sum(int left, int right) {
    this.left = left;
    this.right = right;
    System.out.printf("합: %d\n", left+right+base);
  }
}


public class Practice {

  public static void main(String[] args) {

    Calculator2 myC = new Calculator2();
    myC.sum(10, 30);
    
    Calculator2.base = 10;  // static 으로 선언한 클래스 필드는 다른 클래스에서 수정 가능하다.
    myC.sum(10, 30);
    
    
  }




}
