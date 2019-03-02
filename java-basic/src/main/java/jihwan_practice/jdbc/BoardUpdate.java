package jihwan_practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardUpdate {
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
    String no = null;
    String title = null;
    String cont = null;
    try(Scanner keyboard = new Scanner(System.in)) {
      System.out.print("번호? ");
      no =  keyboard.nextLine();
      System.out.print("제목? ");
      title = keyboard.nextLine();
      System.out.print("내용? ");
      cont = keyboard.nextLine();

    } catch(Exception e) {}

    try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try(Statement stmt = con.createStatement()) {

       int num = stmt.executeUpdate("update x_board set "
            + "title = '" + title + "', contents = '" + cont 
            + "' where board_id = "+ no +"");
        
       if(num == 0) {
         System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
       } else {
         System.out.println("변경하였습니다.");
       }

        
        
        
      } catch (Exception e) {
        System.out.println("DB에 SQL문 전달 실패");
      }

    } catch (Exception e) {
      System.out.println("DB 연결 실패");
    }

  }

}


