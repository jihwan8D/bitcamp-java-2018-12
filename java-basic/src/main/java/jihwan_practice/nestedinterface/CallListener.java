package jihwan_practice.nestedinterface;

public class CallListener implements Button.OnclickListener {
  @Override
  public void onClick() {
    System.out.println("전화를 겁니다.");
  }
}
