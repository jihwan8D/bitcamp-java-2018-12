package jihwan_practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test01 {

  public static void main(String[] args) throws Exception {
    
    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
    
    System.out.println("DB연결성공");
    
    Statement stmt = con.createStatement();
    
    ResultSet rs = stmt.executeQuery(
        "select * from x_board");
    
    stmt.executeUpdate(
        "update x_board set view_count = view_count + 1 where board_id = 1");
    
    while(rs.next()) {
      System.out.printf("%s, %s, %s, %s, %s\n",
          rs.getString("board_id"),
          rs.getString("title"),
          rs.getString("contents"),
          rs.getString("created_date"),
          rs.getString("view_count"));
    }
    
    rs.close();
    stmt.close();
    con.close();
  }

}


