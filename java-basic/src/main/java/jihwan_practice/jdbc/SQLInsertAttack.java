package jihwan_practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SQLInsertAttack {
  // 다음과 같이 게시물을 변경하는 프로그램을 작성하라!
  // ----------------------------
  // 번호? 1
  // 제목? xxx
  // 내용? xxxxx
  // 변경하였습니다.
  // (또는)
  // 해당 번호의 게시물이 존재하지 않습니다.
  //----------------------------
  public static void main(String[] args) {
  
    String title = null;
    String cont = null;
  
    try(Scanner keyboard = new Scanner(System.in)) {

      System.out.print("제목? ");
      title = keyboard.nextLine();
      System.out.print("내용? ");
      cont = keyboard.nextLine();

    } catch(Exception e) {}

    try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try(PreparedStatement pstmt = con.prepareStatement(
          "insert into x_board(title, contents) values(?, ?)")) {
        
        pstmt.setString(1, title);
        pstmt.setString(2, cont);
        
        pstmt.executeUpdate();
        
      } catch (Exception e) {
        
      }

    } catch (Exception e) {
      System.out.println("DB 연결 실패");
    }

  }

}


