package jihwan_practice;

import java.util.Scanner;

public class BankApplication {

  private static Scanner keyboard = new Scanner(System.in);
  private static Account2[] accountArry = new Account2[100];
  static int i = 0;
  public static void main(String[] args) {

    while(true) {
      System.out.println("--------------------------------------------------");
      System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5. 잔액 | 6. 종료");
      System.out.println("--------------------------------------------------");
      System.out.print("선택> ");
      int choice = keyboard.nextInt();


      if(choice == 1) {
        createAccount();

      } else if(choice == 2) {
        accountList();
      } else if(choice == 3) {
        deposit();
      } else if(choice == 4) {
        withdraw();
      } else if(choice == 5) {
        inquiry();
      } else if(choice == 6) {
        System.out.println("종료합니다.");
        break;
      }
    }

  }

  private static void createAccount() {
    System.out.println("----------");
    System.out.println("계좌생성");
    System.out.println("----------");

    System.out.print("계좌번호: ");
    String ano = keyboard.next();

    System.out.print("계좌주: ");
    String owner = keyboard.next();

    System.out.print("초기입금액: ");
    int balance = keyboard.nextInt();

    Account2 a = new Account2(ano,owner,balance );
    accountArry[i++] = a;
    System.out.println("결과: 계좌가 생성되었습니다.");
  }
  private static void accountList() {
    System.out.println("----------");
    System.out.println("계좌목록");
    System.out.println("----------");

    for(int j = 0 ; j < i; j++) {
      String ano = accountArry[j].getAno();
      String owner = accountArry[j].getOwner();
      int balance = accountArry[j].getBalance();
      System.out.printf("%s       %s       %d\n", ano, owner, balance);
    }
  }
  private static void deposit() {
    System.out.println("----------");
    System.out.println("예금");
    System.out.println("----------");
    System.out.print("계좌번호: ");
    String findAno = keyboard.next();
    Account2 y = findAccount(findAno);
    System.out.print("예금액: ");
    int y2 = keyboard.nextInt();
    y.setBalance(y.getBalance() + y2);
  }
  private static void withdraw() {
    System.out.println("----------");
    System.out.println("출금");
    System.out.println("----------");
    System.out.print("계좌번호: ");
    String findAno = keyboard.next();
    Account2 y = findAccount(findAno);
    System.out.print("출금액: ");
    int y2 = keyboard.nextInt();
    y.setBalance(y.getBalance() - y2);
  }
  
  private static void inquiry() {
    System.out.println("----------");
    System.out.println("잔액");
    System.out.println("----------");
    System.out.print("계좌번호: ");
    String findAno = keyboard.next();
    Account2 y = findAccount(findAno);
    System.out.println("잔액: " + y.getBalance());
  }
  private static Account2 findAccount(String ano) {
    for(int i = 0; i<accountArry.length; i++) {
      if(accountArry[i].getAno().equals(ano)) {
        return accountArry[i];
      } 
    }
    return null; 
  }
}
