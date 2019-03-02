package jihwan_practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDetail {
  // 다음과 같이 게시물을 조회하는 프로그램을 작성하라!
  // ----------------------------
  // 번호? 1
  // 제목: aaa
  // 내용: aaaaa
  // 등록일: 2019-1-1
  // 조회수: 2
  // 
  // 번호? 100
  // 해당 번호의 게시물이 존재하지 않습니다.
  //----------------------------
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("번호? ");
    String no = keyboard.nextLine();

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        ResultSet rs = stmt.executeQuery("select title, contents, created_date, view_count "
            + "from x_board where board_id = "+ no +"");

        rs.next();
        System.out.printf("%s, %s, %s, %s\n",
            rs.getString("title"),
            rs.getString("contents"),
            rs.getString("created_date"),
            rs.getString("view_count"));

        rs.close();
      } catch (Exception e) {

      }


    } catch (Exception e) {

    }
    keyboard.close(); 
  }

}


