package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/d03_1")
public class practice5 {

  @RequestMapping(params = "name")
  @ResponseBody
  public String handler() {
  return "handler1";  
  }
}
