package jihwan_practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDelete {
  // 다음과 같이 게시물을 삭제하는 프로그램을 작성하라!
  // ----------------------------
  // 번호? 1
  // 삭제하였습니다.
  // (또는)
  // 해당 번호의 게시물이 존재하지 않습니다.
  //----------------------------
  public static void main(String[] args) throws Exception {

    Scanner keyboard = new Scanner(System.in);
    System.out.print("번호? ");
    String no = keyboard.nextLine();

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        int num = stmt.executeUpdate("delete from x_board where board_id = " + no + "");

        if (num == 0) {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        } else {
          System.out.println("삭제하였습니다.");
        }

      } catch (Exception e) {

      }


    } catch (Exception e) {

    }
    keyboard.close();
  }

}


