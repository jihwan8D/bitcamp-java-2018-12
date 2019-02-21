// DBMS 적용
package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {

  public List<Board> findAll() {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "select board_id, conts, cdt, vw_cnt from lms_board"
              + " order by board_id desc")) {

        try (ResultSet rs = stmt.executeQuery()) {

          ArrayList<Board> list = new ArrayList<>();
          while (rs.next()) {
            Board board = new Board();
            board.setNo(rs.getInt("board_id"));
            board.setContents(rs.getString("conts"));
            board.setCreatedDate(rs.getDate("cdt"));
            board.setViewCount(rs.getInt("vw_cnt"));

            list.add(board);
          }
          return list;
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Board board) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "insert into lms_board(conts) values(?)")) {

        stmt.setString(1, board.getContents());
        stmt.executeUpdate();
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Board findByNo(int no) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_board set vw_cnt = vw_cnt + 1 where board_id = ?")) {
        stmt.setInt(1, no);
        stmt.executeUpdate();
      }

      try (PreparedStatement stmt = con.prepareStatement(
          "select board_id, conts, cdt, vw_cnt from lms_board where board_id = ?")) {

        stmt.setInt(1, no);

        try (ResultSet rs = stmt.executeQuery()) { //리턴 하는건 결과가 아니라 
          // ResultSet => 결과를 가져오는 도구
          if (rs.next()) {

            Board board = new Board();
            board.setNo(rs.getInt("board_id")); // 애트리뷰트 타입이 int면 getInt "board_id" 애트리뷰트 이름
            board.setContents(rs.getString("conts"));
            board.setCreatedDate(rs.getDate("cdt"));
            board.setViewCount(rs.getInt("vw_cnt"));
            return board;

          } else {
            return null;
          }
        }

      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Board board) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_board set conts = ? where board_id = ?")) {
        stmt.setString(1, board.getContents());
        stmt.setInt(2, board.getNo());

        return stmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }


  public int delete(int no) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      try (PreparedStatement stmt = con.prepareStatement(
          "delete from lms_board where board_id = ?")) {
        
        stmt.setInt(1, no);
        
        return stmt.executeUpdate();
      }
      
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
}









