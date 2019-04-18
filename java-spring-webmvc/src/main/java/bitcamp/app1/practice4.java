package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/d02_1")
public class practice4 {
  
  @ResponseBody
  @GetMapping
  public String handler1() {
    return "get";
  }
  
  
  @ResponseBody
  @PostMapping("h1")
  public String handler2() {
    return "post";
  }
  
}
