// 애노테이션 반복 사용
//  => @Repeatable을 사용하여 반복 사용 여부를 지정할 수 있다.
package ch28.d;



@MyAnnotation
//@MyAnnotation
@MyAnnotation2
@MyAnnotation2 // @Repeatible로 선언된 애노테이션인 경우 중복해서 사용할 수 있다.
@MyAnnotation2
public class Test01 {

  public static void main(String[] args) {

  }
}
