package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;

public class BoardHandler {

  final int LENGTH = 10;

  Scanner keyboard;
  Board[] boards = new Board[LENGTH];
  int boardIdx = 0;
  
  public BoardHandler(Scanner keyboard){
    this.keyboard=keyboard;
  }

  public void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setNo(0);

    boards[boardIdx] = board;
    boardIdx++;

    System.out.println("저장하였습니다.");
  }
  
  public void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].getNo(), boards[j].getCreatedDate(), boards[j].getCreatedDate(), boards[j].getViewCount());
    }
  }
  
}
