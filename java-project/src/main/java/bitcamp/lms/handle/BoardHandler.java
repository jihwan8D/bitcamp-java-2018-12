package bitcamp.lms.handle;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.App;
import bitcamp.lms.domain.Board;
import bitcamp.lms.*;
public class BoardHandler {

  public Scanner keyboard;

  public BoardHandler(Scanner keyboard){
    this.keyboard = keyboard;
  }

  Board[] boards = new Board[App.LENGTH];
  int boardIdx = 0;

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);

    //BoardList.add(board);
    boards[boardIdx] = board;
    boardIdx++;

    System.out.println("저장하였습니다.");
  }

  public void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].getNo(), boards[j].getContents(), boards[j].getCreatedDate(), boards[j].getViewCount());
    }
  }

}
