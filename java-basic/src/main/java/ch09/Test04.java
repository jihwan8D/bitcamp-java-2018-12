// 클래스 필드의 한계
package ch09;

public class Test04 {
  public static void main(String[] args) {

    // 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?

    int result1 = 0;
    int result2 = 0;

    result1 = Calculator1.multiple(2, 3); // 식1 계산 => 2
    result2 = Calculator1.divide(6, 2); // 식2 계산 => 6

    result1 = Calculator1.minus(result1, 2);
    result2 = Calculator1.plus(result2, 8);

    result1 = Calculator1.plus(result1, 7);


    System.out.println(result1);
    System.out.println(result2);

  }
}