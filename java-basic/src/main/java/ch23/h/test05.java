// URL 요청하기 - URLConnection 사용
package ch23.h;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class test05 {

  public static void main(String[] args) throws Exception {
    // 파일 시스템
    // => [프로토콜]://서버주소:포트번호/자원의경로
    //    예) file:///c:/Users/bitcamp/a.html
    URL url = new URL("https://www.naver.com");
    
    // URL 정보를 가지고 HTTP 여창을 수행할 객체르 만든다.
    URLConnection con = url.openConnection();
    // URL 형식으로 파일 시스템이 자원을 가리키기(for Windows)
    // 서버와 연결하고 데이터를 읽어들일 도구를 리턴한다
    con.connect();
    
    // 서버와 연결하고 HTTP 요청을 수행한다.
    // 그런 후에 데이터를 읽어들일 도구를 리턴한다.
    InputStream in = con.getInputStream();
    
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
