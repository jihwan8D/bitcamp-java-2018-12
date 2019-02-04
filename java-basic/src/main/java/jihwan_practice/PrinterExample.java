package jihwan_practice;

class Printer {

  public static void println(int a) {
    System.out.println(a);
  }
  public static void println(boolean a) {
    System.out.println(a);
  }
  public static void println(double a) {
    System.out.println(a);
  }
  public static void println(String a) {
    System.out.println(a);
  }
}



public class PrinterExample {

  public static void main(String[] args) {
    Printer.println(10);
    Printer.println(true);
    Printer.println(5.7);
    Printer.println("홍길동");
  }

}
