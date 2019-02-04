package jihwan_practice;

public class Account {
 private int balance; // 잔고
  
  public void setBalance(int balance) {
    if((balance < 0) || balance > 1000000) {
      return;
    } else {
      this.balance = balance;
    }

  }
  
  public int getBalance() {
    return this.balance;
  }
}
