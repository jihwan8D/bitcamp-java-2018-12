package jihwan_practice.thread;

public class ThreadExample2 {

  public static void main(String[] args) throws Exception {

    Thread t1 = new Thread() {

      public void run() {
        for(int i = 0; i < 1000; i++) {
          System.out.println("T1");
        }
      }
    };
    t1.start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for(int i = 0; i < 1000; i++) {
          System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");
        }

      }
    }).start();

    //t1.start(); 실행오류

    t1.join();
    
    for(int i = 0; i < 1000; i++) {
      System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");
    }
  }
}
