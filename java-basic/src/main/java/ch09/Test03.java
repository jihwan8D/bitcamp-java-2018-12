// 클래스 필드의 한계
package ch09;

public class Test03 {
  public static void main(String[] args) {

    // 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?
    
    Calculator2.plus(2); // 식1 계산 => 2
    Calculator2.plus(6); // 식2 계산 => 6

    Calculator2.multiple(3);
    Calculator2.divide(2);
    
    Calculator2.minus(2);
    Calculator2.minus(8);
    
    Calculator2.plus(7);
    
    System.out.println(Calculator2.result);

  }
}