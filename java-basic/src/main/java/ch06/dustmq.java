// 메서드 - 재귀호출
package ch06;

public class dustmq {
  public static void main(String[] args) {
    m1();

    m2("홍길동", 20);

    int a = m3();
    System.out.println("m3 메서드 출력. return 값:"+ a);

    int b = m4(3, 6);
    System.out.println("m4 메서드 출력. return 값:"+ b);

    int result = m4(m4(m4(m4(1, 2), 3), 4), 5);
    System.out.println(result);

    int result2 = m5(1,2,3,4,5);
    System.out.println("m5 메서드 출력. return 값:" + result2);

    int result3 = m6(new int[] {1,2,3,4,5});
    System.out.println("m6 메서드 출력. return 값:" + result3);

    m7("홍길동", new int[] {100, 80, 95});

    m8("임꺽정", new int[] {70,60,80});
  }


  static void m1() {
    System.out.println("m1 메서드 출력");
  }
  static void m2(String name, int age) {
    System.out.printf("m2 메서드 출력: %s, %d\n", name, age);
  }
  static int m3() {
    return 10;
  }
  static int m4(int a, int b) {
    return a + b;
  }
  static int m5(int ...value) {
    int sum = 0;
    for(int i = 0; i < value.length; i++) {
      sum+=value[i];
    }
    return sum;
  }
  static int m6(int[] value) {
    int sum = 0;
    for (int i=0; i<value.length; i++) {
      sum+=value[i];
    }
    return sum;
  }
  static void m7(String name, int total[]) {
    int sum = 0;
    for (int i=0; i<total.length; i++) {
      sum+=total[i];
    }
    System.out.printf("이름: %s, 종합점수: %d\n", name, sum);
  }
  static void m8(String name, int ...total) {
    int sum = 0;
    for (int i=0; i<total.length; i++) {
      sum+=total[i];
    }
    System.out.printf("이름: %s, 종합점수: %d\n", name, sum);
  }

































}