// DBMS에 연결하기 - java.sql.Driver 구현체 조회
package ch25.a;

import java.sql.DriverManager;

public class Test04 {

  public static void main(String[] args) {
    // DriverManager의 getConnection()을 호출할 때 
    // DriverManager는 jdbcURL 정보를 바탕으로 java.sql.Driver 구현체를 찾는다.
    // => 즉 개발자가 코드로 java.sql.Driver 구현체를 직접 등록하지 않아도,
    //    또는 java.sql.Driver를 구현한 클래스를 로딩하지 않아도
    //    자동 로딩한다.
    // => 어떻게?
    //    1) JVM이 알고 있는 모든 .jar 파일을 뒤진다.
    //    2) jar 파일 안에 META-INF/services/java.sql.Driver 파일을 찾는다.
    //    3) 이 파일에 등록된 클래스를 로딩한다.
    // => 그래서 이 예제처럼 개발자가 따로 java.sql.Driver 구현체를 등록하지 않아도 된다.
    //
    try {
      java.sql.Driver dirver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(dirver);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}









