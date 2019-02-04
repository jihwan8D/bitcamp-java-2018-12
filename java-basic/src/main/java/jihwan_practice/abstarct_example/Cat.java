package jihwan_practice.abstarct_example;

public class Cat extends Animal {
  @Override
  public void sound() {
    System.out.println("야옹");
    
  }
  
  public Cat() {
    this.kind = "고양이";
  }
}
