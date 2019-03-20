package ch29.x;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:ch29/x/jdbc.properties")
public class AppConfig {

  @Autowired
  Environment e;
  
  @Bean
  public Car car() {
    
    System.out.println(e.getProperty("jdbc.url"));
    return new Car();
    
  }
}
