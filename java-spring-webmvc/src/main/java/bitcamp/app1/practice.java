package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/d01_1")
public class practice {
  
  @RequestMapping
  @ResponseBody
  public String handler() {
    return "d01_1";
  }
  
  
  
}
