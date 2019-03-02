package jihwan_practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardInsert {
  // 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
  // ----------------------------
  // 제목? aaa
  // 내용? bbb
  // 등록하시겠습니까?(Y/n) y
  // 등록하였습니다.
  // 등록하시겠습니까?(Y/n) n
  // 등록을 취소 하였습니다.
  //----------------------------
  public static void main(String[] args) {
    
   try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
     
     try(Statement stmt = con.createStatement();
         Scanner keyboard = new Scanner(System.in)) {

       System.out.print("제목? ");
       String title = keyboard.nextLine();
       
       System.out.print("내용? ");
       String cont = keyboard.nextLine();
       
       System.out.print("등록하시겠습니까?(Y/n) ");
       String yn = keyboard.nextLine();
       
       if (yn.equalsIgnoreCase("y")) {
         int count = stmt.executeUpdate("insert into x_board(title,contents) "
             + "values('" + title + "', '"+ cont + "')");
       } else {
         System.out.println("등록을 취소 하였습니다.");
       }
       
     } catch(Exception e) {
       System.out.println("SQL문 전달 중 오류 발생");
     }
     
     
     
   } catch(Exception e) {
     System.out.println("DB연결중 오류 발생");
   }

  }

}


