package jihwan_practice.abstarct_example;

public abstract class Animal {
  
  String kind;
  
  public abstract void sound();
  
  public void breath() {
    System.out.println("숨을 쉽니다.");
  }
}
