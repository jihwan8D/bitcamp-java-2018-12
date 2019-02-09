package jihwan_practice.IO;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import ch22.e.Score;

public class Dustmq {

  public static void main(String[] args) {
    // 다음 세 학생의 성적 정보를 score.data 파일에 바이너리 형식으로 저장하라!
    // => java.io.BufferedOutputStream 클래스를 사용하라.
    // => java.io.DataOutputStream 클래스를 사용하라.
    //
    Score student[] = {new Score("홍길동", 100, 100, 100),
                  new Score("임꺽정", 90, 90, 90),
                  new Score("유관순", 80, 80, 80)};
    
    try(FileOutputStream fos = new FileOutputStream("score.data");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream out = new DataOutputStream(bos)) {

     out.writeInt(student.length);
     
     for(Score s : student) {
       out.writeUTF(s.getName());
       out.writeInt(s.getKor());
       out.writeInt(s.getEng());
       out.writeInt(s.getMath());
     }

      out.flush();
    } catch(Exception e) {

    }

  }

}
