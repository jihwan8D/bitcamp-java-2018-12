package jihwan_practice.nestedinterface;

public class ButtonExample {

  public static void main(String[] args) {
    Button button = new Button();

    button.setOnclickListener(new CallListener());
    button.touch();

    button.setOnclickListener(new Button.OnclickListener() {
      public void onClick() {
        System.out.println("사진을 찍습니다.");
      }
    });
    
    button.touch();


    button.setOnclickListener(new Button.OnclickListener() {
      @Override
      public void onClick() {
        System.out.println("메세지를 보냅니다.");
      }
    });
    
    button.touch();
    
    
    
  }
}