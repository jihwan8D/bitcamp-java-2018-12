package jihwan_practice.project.server.domain;
import java.io.Serializable;
import java.sql.Date;

public class Lesson implements Cloneable, Serializable {
  private static final long serialVersionUID = 1L;
  
  private int no;
  private String title;
  private String contents;
  private Date startDate;
  private Date endDate;
  private int totalHours;
  private int dayHours;
  
  public Lesson() { }
  
  public Lesson(int no, String title) {
    this.no = no;
    this.title = title;
  }
  

  @Override
  public Lesson clone() throws CloneNotSupportedException {
    return (Lesson) super.clone();
  }
  @Override
  public String toString() {
    return "Lesson [no=" + no + ", title=" + title + ", contents=" + contents + ", startDate="
        + startDate + ", endDate=" + endDate + ", totalHours=" + totalHours + ", dayHours="
        + dayHours + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getTotalHours() {
    return totalHours;
  }
  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }
  public int getDayHours() {
    return dayHours;
  }
  public void setDayHours(int dayHours) {
    this.dayHours = dayHours;
  }
  
  
}
