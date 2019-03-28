package design_pattern.chain_of_responsibility;

public class TerminalHandler extends AbstractHandler {

  @Override
  public void handle(int a, int b, String op) {
    // 이 핸들러는 연결의 끝을 표현하기 위해 만든 것이다.
    // 아무런 일을 하지 않는다.
  }  
}
