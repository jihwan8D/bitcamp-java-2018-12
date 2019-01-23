package algorithm.data_structure.linkedlist;

public class LinkedList2 {
  protected Node head = new Node();
  protected Node tail = head;
  protected int size = 0;

  // LinkedList는 add() 할 때마다 노드를 만들어 값을 저장하기 때문에 
  // ArrayList 처럼 한 번에 메모리를 준비할 필요가 없다.
  // => 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다.
  public void add(Object value) {
    tail.value = value;
    Node node = new Node();
    tail.next = node;
    node.prev = tail;
    tail = node;
    size++;
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if(index < 0 || index >= size) {
      return null;
    }
    
    Node cursor = head;
    
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node cursor = new Node();
    cursor = head;
    
    for(int i=0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }

  public Object set(int index, Object value) {
    if(index < 0 || index >= size) {
      return null;
    }
    Node cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    
    cursor.value = value;
    
    return old;
  }

  public int insert(int index, Object value) {

    return 0;
  }

  public Object remove(int index) {

    return null;
  }

}











