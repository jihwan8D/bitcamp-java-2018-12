package design_pattern.proxy.before1;

public class App {

  public static void main(String[] args) {
    
    Calculator calc = new Calculator();
    
    System.out.println(calc.plus(100, 200));
    System.out.println(calc.minus(100, 200));

  }

}
