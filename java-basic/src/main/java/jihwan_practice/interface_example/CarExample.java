package jihwan_practice.interface_example;

public class CarExample {

  public static void main(String[] args) {
    Car car = new Car();
    
    car.run();
    
    car.frontLeftTire = new KumhoTire();
    car.frontRightTire = new KumhoTire();
    
    car.run();
  }

}
