package jihwan_practice.network.froxy.before.client;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    CalculatorClient cc = new CalculatorClient();

    while(true) {
      try {
      System.out.print("명령> ");
      String input = keyboard.nextLine();
      

      if (input.equalsIgnoreCase("quit")) {
        cc.quit();
        break;
      }
      String[] c = input.split(" ");
      int num1 = Integer.parseInt(c[0]);
      int num2 = Integer.parseInt(c[2]);

    
        int result = cc.compute(num1, num2, c[1]);
        System.out.printf("%d + %d = %d\n", num1, num2, result);

      } catch (Exception e) {
        System.out.println("식 또는 계산 오류");
      }

    }
  }

}
