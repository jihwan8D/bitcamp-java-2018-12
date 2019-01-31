// java.io.File 클래스 : 연습 과제 - bin 폴더를 삭제하라! 
package ch22.a;

import java.io.File;

public class Test13 {

  public static void main(String[] args) throws Exception {
    
    File dir = new File("bin");
    
     delete(dir);
     System.out.println("삭제 완료!");
  }
  
  static void delete(File dir) {
    File[] files = dir.listFiles();
    for (File file : files) {
      if (file.isFile()) {
        file.delete();
      } else {
        delete(file);
      }
    }
    dir.delete();
  }

  // 디렉토리의 하위 디렉토리와 파일 목록을 얻는다.
  
  // 파일목록에서 파일꺼냄
  // 만약 파일이면 삭제
  // 디렉토리면 delete()호출하여 삭제
}





