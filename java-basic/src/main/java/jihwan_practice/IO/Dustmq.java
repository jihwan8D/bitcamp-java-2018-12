package jihwan_practice.IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Dustmq {

  public static void main(String[] args) {
    // 다음 세 학생의 성적 정보를 score.data 파일에 바이너리 형식으로 저장하라!
    // => java.io.BufferedOutputStream 클래스를 사용하라.
    // => java.io.DataOutputStream 클래스를 사용하라.
    //
    ArrayList<Score> student = new ArrayList<>();
    student.add(new Score("홍길동", 100, 100, 100));
    student.add(new Score("임꺽정", 90, 90, 90));
    student.add(new Score("유관순", 80, 80, 80));


    try(ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("score.data")))) {
      
      out.writeInt(student.size());
      
      for(Score s : student) {
        out.writeObject(s);
      }

      out.flush();
    } catch(Exception e) {

    }

  }

}
