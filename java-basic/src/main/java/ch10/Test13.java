//초기화 블록 - 클래스 로딩과 스태틱 브록 실행 과정
package ch10;

class A { //// 2
  static int a = 7; //// 3

  static { //// 4
    System.out.println("A.static{}"); //// 4.1
    a += B.b; //// 4.2  //// 8(a=(29+7)=36)
  }
}

class B { //// 5
  static int b = 22; //// 6

  static { //// 7
    System.out.println("B.static{}"); ////7.1
    b += A.a; //// 7.2 (b=29)
  }
}
public class Test13 {
  public static void main(String[] args) { //// 1
    System.out.println(A.a); //// 1.1  //// 9
    System.out.println(B.b); //// 10

    // 클래스 로딩 절차
    // 1) 클래스를 Method Area에 로딩한다.
    // 2) 스태틱 변수를 만든다.
    // 3) 스태틱 블록을 실행한다.

    // 클래스 로딩
    // => 클래스 멤버(변수, 메서드)를 사용할 때
   // => class.forName("클래스명") 을 통해 임의로 로딩할 때
    // => 단 한 번 로딩된 클래스는 다시 로딩하지 않는다.
  
    // 스태틱 블록의 목적
    // => 클래스 멤버(스태틱 변수, 스태틱 메서드)를 사용하기 전에 유요한 값으로 초기화 시키는 것이다.
  }
}