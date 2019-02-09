package jihwan_practice.IO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import ch22.e.Score;

public class Dustmq2 {

  public static void main(String[] args) {
    // score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라.
    // => java.io.BufferedInputStream 클래스를 사용하라.
    // => java.io.DataInputStream 클래스를 사용하라.
    //

    try(DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("score.data")))) {
      int len = in.readInt();
      Score[] student = new Score[len];

      for(int i = 0; i < student.length; i++  ) {
        Score s = new Score();
        s.setName(in.readUTF());
        s.setKor(in.readInt());
        s.setEng(in.readInt());
        s.setMath(in.readInt());
        student[i] = s;
      }
      for (Score s : student)
        System.out.printf("%s, %d, %d, %d \n", s.getName(), s.getKor(), s.getEng(), s.getMath());

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
