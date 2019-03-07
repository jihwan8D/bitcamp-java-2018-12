// dynamic SQL 다루기 - #{} , ${} 사용법
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test07 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    HashMap<String,Object> params = new HashMap<>();

    
    Scanner keyboard = new Scanner(System.in);
    System.out.print("정렬할 컬럼? ");
    String column = keyboard.nextLine();
    if (column.length() > 0) {
      params.put("column", column);
    }

    System.out.print("정렬방식? ");
    String sort = keyboard.nextLine();
    if (sort.length() > 0) {
      params.put("sort", sort);
    }

    keyboard.close();

    List<Board> boards = sqlSession.selectList("board.select7_ok", params);

    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

  }

}