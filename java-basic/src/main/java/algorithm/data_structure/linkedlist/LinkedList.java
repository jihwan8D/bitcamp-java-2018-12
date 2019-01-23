package algorithm.data_structure.linkedlist;

public class LinkedList {
  Node head;
  Node tail;
  int size;
  
  public LinkedList() {
    head = new Node(); // 맨 첫번째 노드의 주소를 head에 넣고 
    tail = head;        // head의 주소를 tail에 넣음
    size = 0;
  }
  
  // LinkedList는 add() 할 때마다 노드를 만들어 값을 저장하기 때문에 
  // ArrayList 처럼 한 번에 메모리를 준비할 필요가 없다.
  // => 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다.
  public void add(Object value) {
    tail.value = value;
    
    // 새 노드를 준비한다.
    Node node = new Node();

    // 마지막 노드의 다음으로 새 노드를 가리키게 한다.
    tail.next = node;
    
    // 새 노드의 이전으로 마지막 노드를 가리키게 한다.
    node.prev = tail;
    
    // tail이 새로 추가된 노드를 가리키게 한다.
    tail = node;
    
    // 항목 개수를 증가시킨다.
    size++;
  }
  
  public int size() {
    return size;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;
    
    Node cursor = head; // 맨처음 노드의 주소를 넣음. ex) 200번지
    
    // 해당 인덱스로 이동한다.
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next; // 다음번째 번지인 300번지 넣음 //헤드가 현재값이니깐 그다음 번지를 넣어줌 또 다음번지 들어간 번지를 넣어줌 원하는 번지까지
    }
    // cursor가 가리키는 노드의 주소를 리턴?
    // => 노드의 값을 리턴
    return cursor.value;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[size()];

    Node cursor = head;
    
    int i =0;
    while(cursor != tail) { //tail과 같지 않을때만 값을꺼냄 
      arr[i++] = cursor.value;
      cursor = cursor.next;
    }
    return arr; // 배열의 주소를 리턴
  }
  
  public Object set(int index, Object value) {
    if(index < 0 || index >= size)
      return null;
    
    Node cursor = head;
    
    // 교체할 값이 들어 있는 노드로 이동한다.
    for (int i = 1; i<=index; i++) {
      cursor = cursor.next; // 커서가 커서가 가르키는 노드에 다음값
    }
    // 변경 전에 이전 값을 보관한다.
    Object old = cursor.value;
    
    // 값을 변경한다.
    cursor.value = value;
    
    // 이전 값을 리턴한다. 쓰든 안쓰든 호출하는 사람이 알아서 할 일이다.
    // 다만 변경 전 값을 활용할 경우를 대비해 리턴하는 것이다.
    return old;
  }

//값을 삽입하는 경우에는 ArrayList 방식 보다 효율적이다.
 // 사입 위치에 있는 노드를 찾은 후에 새 노드를 앞, 뒤 노드에 연결하면 된다.
 public int insert(int index, Object value) {
   if (index < 0 || index >= size)
     return -1;
   
   // 새 노드를 만들어 값을 담는다.
   Node node = new Node(value);
   
   // 삽입할 위치에 있는 원래 노드를 찾는다.
   Node cursor = head;
   for (int i = 1; i <= index; i++) {
     cursor = cursor.next;
   }
   
   // 새 노드가 찾은 노드를 가리키게 한다.
   node.next = cursor;
   
   // 찾은 노드의 이전 노드 주소를 새 노드의 이전 노드 주소로 설정한다.
   node.prev = cursor.prev;
   
   // 찾은 노드의 이전 노드로 새 노드를 가리키게 한다.
   cursor.prev = node;
   
   if (node.prev != null) {
     // 이전 노드의 다음 노드로 새 노드를 가리키게 한다.
     node.prev.next = node;
   } else {
     // 맨 앞에 노드를 추가할 때는 head를 변경해야 한다.
     head = node;
   }
   
   // 크기를 늘린다.
   size++;
   
   return 0;
 }
}











