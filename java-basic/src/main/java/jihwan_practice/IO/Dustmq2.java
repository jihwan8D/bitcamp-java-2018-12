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
      
     Score s1 = new Score();
     s1.setName(in.readUTF());
     s1.setKor(in.readInt());
     s1.setEng(in.readInt());
     s1.setMath(in.readInt());
     
     Score s2 = new Score();
     s2.setName(in.readUTF());
     s2.setKor(in.readInt());
     s2.setEng(in.readInt());
     s2.setMath(in.readInt());

     Score s3 = new Score();
     s3.setName(in.readUTF());
     s3.setKor(in.readInt());
     s3.setEng(in.readInt());
     s3.setMath(in.readInt());

     System.out.printf("%s, %d, %d, %d \n", s1.getName(), s1.getKor(), s1.getEng(), s1.getMath());
    } catch(Exception e) {

    }
  }

}
