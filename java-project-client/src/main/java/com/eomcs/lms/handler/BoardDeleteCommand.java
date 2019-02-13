package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  List<Board> list;
  
  public BoardDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {

    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
   
    ////////////////////////////////////
    try {
      out.writeUTF("/board/delete");
      out.flush();
      if(!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
      
      out.writeInt(no);
      out.flush();
      String status = in.readUTF();

      if(!status.equals("OK")) 
        throw new Exception("서버에서 게시글 삭제 실패.");
        
    } catch(Exception e) {
      System.out.printf("게시글 삭제 오류! : %s\n", e.getMessage());
    }
    ////////////////////////////////////

    int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    list.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
  
  private int indexOfBoard(int no) {
    for (int i = 0; i < list.size(); i++) {
      Board b = list.get(i);
      if (b.getNo() == no)
        return i;
    }
    return -1;
  }
}
