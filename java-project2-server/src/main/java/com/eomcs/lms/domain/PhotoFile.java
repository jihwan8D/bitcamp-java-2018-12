package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class PhotoFile implements Serializable {
  private static final long serialVersionUID = 1L;

  private int no;
  private String phtoBoardNo;
  private String filePath;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getPhtoBoardNo() {
    return phtoBoardNo;
  }
  public void setPhtoBoardNo(String phtoBoardNo) {
    this.phtoBoardNo = phtoBoardNo;
  }
  public String getFilePath() {
    return filePath;
  }
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

}
