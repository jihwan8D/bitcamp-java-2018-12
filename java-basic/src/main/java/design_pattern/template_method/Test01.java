// 템플릿 메서드 패턴 - 수퍼 클래스에 기본 실행 흐름을 정의하고 서브 클래스에서 세부 항목을 구현한다.
package design_pattern.template_method;

public class Test01 {

  public static void main(String[] args) {
    /* 예: 스타크래프트에서 건물짓기
     * => 건물을 짓는 과정은 같다.
     * => 그러나 어떤 건물이냐에 따라 출력되는 화면이 다르다.
     */
    
    // 식당 짓기
    Restaurant u1 = new Restaurant();
    u1.setName("군인식당.");
    u1.setArea(50);
    u1.setType(Unit.GENERAL_BUILDING);
    u1.build(); // 수퍼 클래스에서 상속 받은 메서드를 호출한다. // Unit의 build() (서브 클래스에서 build가 상속받았다.)-> Restaurant의 메서드로 가서 읽음
    
    System.out.println("-------------------------------");
    // 훈련소 짓기
    Restaurant u2 = new Restaurant();
    u2.setName("훈련소");
    u2.setArea(500);
    u2.setType(Unit.GENERAL_BUILDING);
    u2.build();
  }

}
