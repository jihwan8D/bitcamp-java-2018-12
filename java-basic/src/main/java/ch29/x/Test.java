package ch29.x;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
    
    System.out.println("객체 생성 완료");
  }
}
