package bitcamp.lms.handle;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;

public class BoardHandler {

  public Scanner keyboard;
  ArrayList list = new ArrayList();

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);

    list.add(board);

    System.out.println("저장하였습니다.");
  }

  public void listBoard() {
    Object[] objs = list.toArray();
    for(Object obj : objs) {
      Board board = (Board) obj;
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }

}//////////////////////////