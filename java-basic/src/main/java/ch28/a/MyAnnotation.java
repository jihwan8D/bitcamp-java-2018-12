package ch28.a;

// 애노테이션 정의
// => 애노테이션의 유지 범위는 기본이 CLASS 이다.
// => .class 파일까지만 유지된다.
// 즉 .class 파일에 애노테이션 정보가 남아 있다.
// => 실행할 때는 메모리에 로딩되지 않는다.
public @interface MyAnnotation {

}
