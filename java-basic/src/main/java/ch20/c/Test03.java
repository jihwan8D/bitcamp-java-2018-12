// java.util.Set 클래스 사용법 - add()와 hashCode(), equals()
package ch20.c;

import java.util.HashSet;
import java.util.Iterator;

public class Test03 {

  public static void main(String[] args) {
    class Student {
 
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
      }

      @Override
      public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Student other = (Student) obj;
        if (age != other.age)
          return false;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false;
        return true;
      }
  


      String name;
      int age;

      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }


      public Student (String name, int age) {
        this.name = name;
        this.age = age;
      }

    }

    HashSet<Student> set = new HashSet<>();
    
    // Set에 값 추가하기
    set.add(new Student("aaa", 20));
    set.add(new Student("bbb", 30));
    set.add(new Student("ccc", 40));

    // Set은 집합의 특성을 따른다.
    // => 같은 값을 중복해서 넣을 수 없다.
    // => 같은 값인지 판단하는 기준은?
    //   equals()의 리턴 값이 true 인지 여부.
    //   hashCode()의 값이 같은지 여부
    // => 현재 Student 로컬 클래스는 equals()와 hashCode()를 오버라이딩 하였다.
    //    따라서 인스턴스는 다르지만 equals()의 결과가 true이고,
    //    hashCode()의 리턴 값도 같기 때문에 종복되지 않는다.
    // => HashSet에서 값을 저장할 때 그 위치는
    //    hashCode()의 리턴 값으로 결정한다.
    //    
    set.add(new Student("aaa", 20));
    set.add(new Student("bbb", 30));



    Iterator<Student> iterator = set.iterator();

    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    System.out.println("------------------------------------");

    Object[] values = set.toArray();
    for (Object value : values) {
      System.out.println(value);
    }
    System.out.println("------------------------------------");

    Student[] values2 = set.toArray(new Student[0]);
    for (Student value : values2) {
      System.out.println(value);
    }

    System.out.println("------------------------------------");
  }
}
