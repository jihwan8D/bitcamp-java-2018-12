package jihwan_practice.IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Dustmq2 {

  public static void main(String[] args) {
    // score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라.
    // => java.io.BufferedInputStream 클래스를 사용하라.
    // => java.io.DataInputStream 클래스를 사용하라.
    //
    ArrayList<Score> students = new ArrayList<>();

    try(ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("score.data")))) {
      

      int len = in.readInt();
      
      for(int i = 0; i < len; i++) {
        Score s = (Score) in.readObject();
        students.add(s);
      }
      for(Score s : students) {
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
            s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
