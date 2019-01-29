package jihwan_practice;

import java.util.HashSet;
import java.util.Iterator;

public class sasdf {

  public static void main(String[] args) {
    HashSet<String> set  = new HashSet<>();
    
    set.add("aaa");
    set.add("bbb");
    set.add("ccc");
    set.add("ccc");
    
    System.out.println(set);
    
    Iterator<String> iterator = set.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    Object[] values = set.toArray();
    for(Object value : values) {
      System.out.println(value);
    }
    
    String[] s1 = new String[0];
    String[] s2 = set.toArray(s1);
    for(String s : s2) {
      System.out.println(s);
    }
    
    String[] s3 = new String[set.size()];
    set.toArray(s3);
    for(String s4 : s3) {
      System.out.println(s4);
    }
  }
}
