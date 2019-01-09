// 메서드 - 로컬 변수의 생성과 소멸
package ch06;

public class Test11 {
  public static void main(String[] args) {
    int value = 100;
  
    // 메서드를 호출할 때 파라미터의 값으로 기본 데이터 타입의 값을 넘겨주는 경우
    // call by value 라 부른다.
    m1(value);
    System.out.println(value);
    
    // 2) call by reference
    // 메서드를 호출할 때 파라미터 값으로 메모리의 주소를 넘긴다.
    int[] arr = new int[] {100, 200, 300};
    System.out.println(arr[1]);
    m2(arr); // arr의 값을 넘긴다. 어? 그러면 call by value가 아닌가요?
    System.out.println(arr[1]);
  }
  
  
  static void m1(int value) {
    value *= 2;
  }
  
  static void m2(int[] arr) {
    arr[1] = 111;
  }
}
