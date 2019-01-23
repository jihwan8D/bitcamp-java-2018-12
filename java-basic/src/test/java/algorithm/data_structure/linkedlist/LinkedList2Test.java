package algorithm.data_structure.linkedlist;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedList2Test {

  @Test
  public void testAdd() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);

    assertEquals(6, list.size()); // 좌 우가 같으냐 
  }

  @Test
  public void testGet() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(100, list.get(0)); // 0번째 방이 100이냐
    assertEquals(300, list.get(2));
    assertEquals(600, list.get(5)); 
    
    assertNull(list.get(-1)); //-1번째 방이 널이냐
    assertNull(list.get(6));
  }
  
  @Test
  public void testToArray() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    Object[] arr = list.toArray();
    assertEquals(6, arr.length); // 6개인지확인
    assertArrayEquals(new Object[] {100,200,300,400,500,600}, arr);// 배열과 똑같은지
  }
  
  @Test
  public void testSet() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(300, list.set(2, 55)); // 값이 같냐 / 2번방 값을 55로바꿔라
    assertEquals(55, list.get(2)); // 새값이랑 맞는지확인

    assertEquals(100, list.set(0, 55)); // 값이 같냐 / 2번방 값을 55로바꿔라
    assertEquals(55, list.get(0)); // 새값이랑 맞는지확인
    
    assertEquals(600, list.set(5, 55)); // 값이 같냐 / 2번방 값을 55로바꿔라
    assertEquals(55, list.get(5)); // 새값이랑 맞는지확인

    assertArrayEquals(new Object[] {55,200,55,400,500,55}, list.toArray());
    assertNull(list.set(-1, 1000));
    assertNull(list.set(6, 1000));
  }
  
  @Test
  public void testInsert() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(-1, list.insert(-1, 55));
    assertEquals(-1, list.insert(6, 55));//잘못된 값이 오면 리턴-1 인데 리턴값이랑 같냐
    
    assertEquals(0, list.insert(2, 55));
    assertArrayEquals(
        new Object[] {100, 200, 55, 300, 400, 500, 600}, list.toArray());
    
    assertEquals(0, list.insert(0, 55));
    assertArrayEquals(
        new Object[] {55, 100, 200, 55, 300, 400, 500, 600}, list.toArray());
    
    assertEquals(0, list.insert(7, 55));
    assertArrayEquals(
        new Object[] {55, 100, 200, 55, 300, 400, 500, 55, 600}, list.toArray());
  }
  
  @Test
  public void testRemove() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(300, list.remove(2)); //2번방 3번삭제
    assertEquals(400, list.remove(2));
    assertArrayEquals(
        new Object[] {100, 200, 500, 600}, list.toArray());
    
    assertEquals(600, list.remove(3));
    assertArrayEquals(
        new Object[] {100, 200, 500}, list.toArray());
    
    assertEquals(100, list.remove(0));
    assertArrayEquals(
        new Object[] {200, 500}, list.toArray());
    
    assertEquals(200, list.remove(0));
    assertEquals(500, list.remove(0));
    assertArrayEquals(
        new Object[] {}, list.toArray());
    
  }
}
