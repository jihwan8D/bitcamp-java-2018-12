package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class practice2 {
  
  @RequestMapping("/d01_2")
  @ResponseBody
  public String handler1() {
    return "d01_2";
  }
  
  @RequestMapping("/d01_3")
  @ResponseBody
  public String handler2() {
    return "d01_3";
  }
  
}
