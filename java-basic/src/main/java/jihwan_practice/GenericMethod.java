package jihwan_practice;

class A { }

class B {
   public static <E> A gm(E value) {
     
     return null;
   }
}

public class GenericMethod {

  public static void main(String[] args) {
    
    B.gm("Hello");
    
  }

}
