package jihwan_practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardList {
  // 다음과 같이 게시물 목록을 출력하라!
  // 게시물 번호를 내림차순으로 정렬하라.
  // ----------------------------
  // 번호, 제목, 등록일, 조회수
  // 2, aaa, 2019-1-1, 2
  // 1, bbb, 2018-12-31, 3
  //----------------------------
  public static void main(String[] args) {

    try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try(Statement stmt = con.createStatement()){

        try(ResultSet rs = stmt.executeQuery("select * from x_board")) {

          while(rs.next()) {
            System.out.printf("%s, %s, %s, %s\n",
                rs.getString("board_id"),
                rs.getString("title"),
                rs.getString("created_date"),
                rs.getString("view_count"));
          }

        } catch(Exception e) {
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

    } catch(Exception e) {
      System.out.println("DB연결중 오류발생");
    }

  }

}


