// 인스턴스 필드의 등장
package ch09;

public class Test05 {
  public static void main(String[] args) {

    // Calculator3를 사용하여 두 계산식을 동시에 실행하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 9 = ?

    Calculator3 c1 = new Calculator3();
    Calculator3 c2 = new Calculator3();

    Calculator3.plus(c1/*result 변수가 있는 인스턴스 주소*/, 2);
    Calculator3.plus(c2, 6);
    
    Calculator3.multiple(c1, 3); // 식1 계산 => 2
    Calculator3.divide(c2, 2); // 식2 계산 => 6

    Calculator3.minus(c1, 2);
    Calculator3.plus(c2, 9);

    Calculator3.plus(c1, 7);


    System.out.println(c1.result);
    System.out.println(c2.result);

  }
}