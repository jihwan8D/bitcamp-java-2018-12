package jihwan_practice.nestedclassexample4;

public class NestedCalssExample {

  public static void main(String[] args) {
    Car myCar = new Car();
    
    Car.Tire tire = myCar.new Tire();
    
    Car.Engine engine = new Car.Engine();
  }

}
