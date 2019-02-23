package jihwan_practice.thread;

public class ThreadExample {

  static class MyThread extends Thread {
    
    @Override
    public void run() {
      for(int i = 0; i < 100; i++) {
        System.out.println("11111111111111111111111111");
      }
    }
  }

  static class MyWork implements Runnable {

    @Override
    public void run() {
      for(int i = 0; i < 1000; i++) {
        System.out.println("2222222222222222222222222222");
      }

    }
  }

  public static void main(String[] args) {

    MyThread myThread = new MyThread();
    
    myThread.start();
    
    MyWork myWork = new MyWork();
    Thread t = new Thread(myWork);
    t.start();
    
    
    for(int i = 0; i < 100; i++) {
      System.out.println("3333333333333333333333333333333");
    }
  }

}
