package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import com.eomcs.lms.domain.Board;

// 서버쪽에 있는 BoardDaoImpl 객체를 대행할 클라이언트측 대행자 클래스 정의 
//
public class BoardDaoImpl implements BoardDao {

  @SuppressWarnings("unchecked")
  public void findAll() {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        try (ResultSet rs = stmt.executeQuery(
            "select * from board_table order by no desc")) {

          while (rs.next()) {
            System.out.printf("%d, %s, %s, %d\n", 
                rs.getInt("no"), 
                rs.getString("contents"), 
                rs.getDate("date"),
                rs.getInt("view_count"));
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void insert(Board board) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        stmt.executeUpdate(
            "insert into board_table(no,contents)"
                + " values('" + board.getNo() + "','" + board.getContents() + "')");

        System.out.println("등록하였습니다.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void findByNo(int no) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        try (ResultSet rs = stmt.executeQuery(
            "select * from board_table where no = " + no)) {

          if (rs.next()) {
            System.out.printf("내용: %s\n", rs.getString("contents"));
            System.out.printf("작성일: %s\n", rs.getInt("no"));
          } else {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
          }
          
        }
      }
     // return 1;
    } catch (Exception e) {
      e.printStackTrace();
    }
   // return 1;
  }

  @Override
  public int update(int no, String input) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      // PreparedStatement는 미리 SQL 문장을 준비하여 값을 삽입하는 기법이다.
      try (PreparedStatement stmt = con.prepareStatement(
          "update board_table set contents = ? where no = ?")) {

        stmt.setString(1, input);
        stmt.setInt(2, no);

        int count = stmt.executeUpdate();

        if (count == 0) {
          return 0;
        } 
        
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 1;
  }

  public int delete(int no) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        // delete 문장은 executeUpdate()를 사용하여 서버에 전달한다.
        int count = stmt.executeUpdate(
            "delete from board_table where no = " + no);

        if (count == 0) {
            return 0;
        } 
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return 1;
  }


}









