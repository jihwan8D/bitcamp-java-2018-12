package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/d01_4")
public class practice3 {
  
  @RequestMapping("h1")
  @ResponseBody
  public String handler1() {
    return "d01_4";
  }
  
  
}
