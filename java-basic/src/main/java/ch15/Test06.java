// Object 클래스 - equals() 오버라이딩
package ch15;

class My6 {
  String name;
  int age;
 }

public class Test06 {

  public static void main(String[] args) {

    My6 obj1 = new My6();
    obj1.name = "홍길동";
    obj1.age = 20;

    My6 obj2 = new My6();
    obj2.name = "홍길동";
    obj2.age = 20;
    System.out.println(obj1.hashCode());
    System.out.println(obj2.hashCode());
    System.out.println(Integer.toHexString(obj1.hashCode()));
    System.out.println(Integer.toHexString(obj2.hashCode()));
  }
}
