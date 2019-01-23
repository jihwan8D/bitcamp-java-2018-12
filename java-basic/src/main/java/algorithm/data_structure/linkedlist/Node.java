package algorithm.data_structure.linkedlist;

public class Node {
  public Object value;
  public Node prev;
  public Node next;

  public Node() { }

  public Node(Object value) {
    this.value = value;
  }

  public Node(Object value, Node prev, Node next) {
    this(value);
    this.prev = prev;
    this.next = next;
  }
}
