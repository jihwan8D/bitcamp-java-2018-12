package jihwan_practice;

public class MemberServiceExample {

  public static void main(String[] args) {
    MemberService m1 = new MemberService();
    
    boolean result = m1.login("hong", "12345");
    System.out.println(result);
  }

}
