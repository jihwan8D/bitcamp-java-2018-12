// 요청 핸들러의 아규먼트 - @RequestParam
package bitcamp.app1;

import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_3")
public class Controller04_3 {

  // 클라이언트가 보낸 요청 파라미터 값을 값 객체에 받을 수 있다.
  
  // => 요청 핸들러의 아규먼트가 값 객체라면, 
  //    프론트 컨트롤러는 메서드를 호출할 때 값 객체의 인스턴스를 생성한 후
  //    요청 파라미터와 일치하는 프로퍼티에 대해 값을 저장한다.
  //    그리고 호출할 때 넘겨준다.
  // => 값 객체의 프로퍼티 이름과 일치하는 요청 파라미터가 있다면
  //
  //
  // http://localhost:8080/java-spring-webmvc/app1/c04_3/h1?model=sonata&maker=hyundai&capacity=5&auto=true
  
  
  @GetMapping("h1") 
  @ResponseBody 
  public void handler1(
     PrintWriter out,
     String model,
     String maker,
     int capacity,
     boolean auto,
     Car car
     ) {
    
    out.printf("model=%s\n", model);
    out.printf("maker=%s\n", maker);
    out.printf("capacity=%s\n", capacity);
    out.printf("auto=%s\n", auto);
    out.printf("car=%s\n", car);
  }
  
}




