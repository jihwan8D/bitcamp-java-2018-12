// request handler를 구분하는 방법 - 파라미터 이름으로 구분하기
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c03_1")
public class Controller03_1 {

  // 테스트 방법:
  // => http://localhost:8080/java-spring-webmvc/app1/c03_1?name=kim
  @GetMapping(params="name") // 웹 브라우저의 파라미터가 name이 있으면 이 메서드가 실행된다.
  @ResponseBody 
  public String handler1() {
    return "handler1";
  }
  
  //테스트 방법:
  // => http://localhost:8080/java-spring-webmvc/app1/c03_1?age=20
  @GetMapping(params="age") 
  @ResponseBody 
  public String handler2() {
    return "handler2";
  }
  
  //테스트 방법:
  // => http://localhost:8080/java-spring-webmvc/app1/c03_1?name=kim&age=20
  @GetMapping(params={"age","name"}) 
  @ResponseBody 
  public String handler3() {
    return "handler3";
  }
}