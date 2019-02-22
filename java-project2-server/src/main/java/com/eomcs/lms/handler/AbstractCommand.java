package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class AbstractCommand implements Command {

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      execute(new Response(in, out));
    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }

  public void execute(Response response) throws Exception {
    // 서브 클래스에서 오버라이딩 해야할 메서드이다.
    // 그러나 서브클래스가 반드시 오버라이딩 하도록 강요하지 않기 위해 추상 메서드로 선언하지 않는다.
    // 왜? 서브 클래스는 Command의 execute(BufferedReader, PrintWriter)를
    // 오버라이딩 할지도 모르기 때문이다.
  }

}
