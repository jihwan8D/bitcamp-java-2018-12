package algorithm.data_structure.stack;

public class Stack {
  
  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size=0;
  
  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }
  public void push(Object value) {
    // 맨 마지막에 추가한다.
    // 배열의 크기가 작다면 확장해야 한다.
    if (size == list.length) {
      Object[] newC = new Object[list.length + (list.length >> 1)];
      for(int i = 0; i < list.length; i++) {
        newC[i] = list[i];
      }
      list = newC;
    }
    list[size++] = value;
  }
  
  public Object pop() {
    // 맨 마지막 값을 꺼내 리턴한다.
    // 꺼낸 값을 배열에서 제거되어야 한다.
    if (size == 0) {
      return null;
    }
    /*
    Object newL = new Object();
    
    newL = list[size];
    list[size] = null;  
    size--;
    return newL;
    */
    return list[--size]; // 배열은 하나 작은 수니깐..
  }
  
  public boolean empty() {
    return size == 0;
  }
  
  public int size() {
    return this.size;
  }
}
