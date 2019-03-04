package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoFileDaoImpl implements PhotoFileDao {

  // 외부에서 커넥션 객체를 주입 받는다.
  Connection con;

  public PhotoFileDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public List<PhotoFile> findAll() {
    try (PreparedStatement stmt = con.prepareStatement(
        "select photo_file_id, file_path from lms_photo_file"
            + " order by photo_file_id desc")) {

      try (ResultSet rs = stmt.executeQuery()) {

        ArrayList<PhotoFile> list = new ArrayList<>();
        while (rs.next()) {
          PhotoFile photoBoard = new PhotoFile();
          photoBoard.setNo(rs.getInt("photo_file_id"));
          photoBoard.setFilePath(rs.getString("file_path"));

          list.add(photoBoard);
        }
        return list;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
/*
  @Override
  public void insert(PhotoFile photoBoard) {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo(titl,lesson_id) values(?,?)")) {

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getLessonNo());
      stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public PhotoFile findByNo(int no) {
    try {
      // 조회수 증가시키기
      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_photo set vw_cnt = vw_cnt + 1 where photo_id = ?")) {
        stmt.setInt(1, no);
        stmt.executeUpdate();
      }

      try (PreparedStatement stmt = con.prepareStatement(
          "select photo_id, titl, cdt, vw_cnt, lesson_id from lms_photo"
          + " where photo_id = ?")) {

        stmt.setInt(1, no);

        try (ResultSet rs = stmt.executeQuery()) {

          if (rs.next()) {
            PhotoFile photoBoard = new PhotoFile();
            photoBoard.setNo(rs.getInt("photo_id"));
            photoBoard.setTitle(rs.getString("titl"));
            photoBoard.setCreatedDate(rs.getDate("cdt"));
            photoBoard.setViewCount(rs.getInt("vw_cnt"));
            photoBoard.setLessonNo(rs.getInt("lesson_id"));
            return photoBoard;
            
          } else {
            return null;
          }
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  @Override
  public int update(PhotoFile photoBoard) {
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_photo set titl = ? where photo_id = ?")) {

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getNo());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  @Override
  public int delete(int no) {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_photo where photo_id = ?")) {

      stmt.setInt(1, no);

      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  */
}
