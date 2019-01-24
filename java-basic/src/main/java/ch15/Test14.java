// Object 클래스 - getClass() 와 배열의 항목 이름
package ch15;

public class Test14 {
  public static void main(String[] args) {
    // 배열의 클래스 정보
    String[] obj2 = new String[10];
    Class classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); // java.lang.String
    
    // 배열 항목의 타입 정보를 가져온다
    Class compTypeInfo = classInfo.getComponentType();
    System.out.println(compTypeInfo.getName());
    
    System.out.println(obj2.getClass().getComponentType().getName());

  }
}







