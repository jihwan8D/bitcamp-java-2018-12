package jihwan_practice;

class Box<T> {
 private T t;
 
 public void set(T t) {
   this.t = t;
 }
 
 public T get() {
   return t;
 }
}
//////////////////////////////////////
public class Generic {

 public static void main(String[] args) {
   Box<String> box1 = new Box<>();  // 인스턴스를 생성할 때 괄호 <> 안에 있는 타입으로 위의 Box클래스가 내부적으로 재구성 된다. 
                                         // T라고 써있는 부분이 String으로 다시 재구성 된다.
   box1.set("hello");
   
  String s1 = box1.get();
  
  
  Box<Integer> box2 = new Box<>();
  
  box2.set(1000);
  
  int value = box2.get();
  /************************************/
  Box box3 = new Box();
  
  box3.set("abcdEfG");
  
  String s2 = (String) box3.get(); // 제네릭을 적용하지 않아 String타입의 s2에 저장하려 하면 타입이 맞지 않아 에러가 발생한다.
                                   // 그래서 (String)으로 강제 타입 변환을 해줘야 한다.
    
  /************************************/
 }
}
