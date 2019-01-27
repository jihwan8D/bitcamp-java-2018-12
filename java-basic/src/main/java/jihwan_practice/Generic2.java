package jihwan_practice;

class Tv { Object obj;}
class Car { }

class Product<T, M> {
  
  private T kind;
  private M modle;
  
  public T getKind() {
    return kind;
  }
  public void setKind(T kind) {
    this.kind = kind;
  }
  public M getModle() {
    return modle;
  }
  public void setModle(M modle) {
    this.modle = modle;
  }
}

public class Generic2 {

  public static void main(String[] args) {
    Product<Tv, String> product1 = new Product<>();
    product1.setKind(new Tv());
    product1.setModle("SmartTV");
    Tv tv = product1.getKind();
    String modle = product1.getModle();
    
    Product<Car, String> product2 = new Product<>();
    product2.setKind(new Car());
    product2.setModle("디젤");
    Car car = product2.getKind();
    String model = product2.getModle();
    
    
  }

}
