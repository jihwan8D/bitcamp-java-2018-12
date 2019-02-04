package jihwan_practice;

public class ShopServiceExample {

  public static void main(String[] args) {
    ShopService s1 = ShopService.getInstance();
    ShopService s2 = ShopService.getInstance();

    if(s1==s2) {
      System.out.println("같은객체");
    } else {
      System.out.println("다른객체");
    }
  }

}
