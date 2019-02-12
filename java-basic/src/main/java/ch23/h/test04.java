// URL 요청하기;
package ch23.h;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class test04 {

  public static void main(String[] args) throws Exception {
    // 파일 시스템
    // => [프로토콜]://서버주소:포트번호/자원의경로
    //    예) file:///c:/Users/bitcamp/a.html
    
    
    // URL 형식으로 파일 시스템이 자원을 가리키기(for Windows)
    URL url = new URL("https://www.naver.com");
    
    // 서버와 연결하고 데이터를 읽어들일 도구를 리턴한다
    url.openStream();
    
    // 서버와 연결하고 HTTP 요청을 수행한다.
    // 그런 후에 데이터를 읽어들일 도구를 리턴한다.
    InputStream in = url.openStream();
    
    // 서버가 보낸 데이터를 한 줄씩 읽기 위해 데코레이터를 붙인다.
    BufferedReader in2 = new BufferedReader(new InputStreamReader(in));
   
    while(true) {
      String str = in2.readLine();
      if(str == null) 
        break;
      System.out.println(str);
    }
    in2.close();
    in.close();
    
  }

}
