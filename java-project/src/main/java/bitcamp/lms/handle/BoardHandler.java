package bitcamp.lms.handle;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;
import bitcamp.lms.handle.BoardList;

public class BoardHandler {

  public Scanner keyboard;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  BoardList boardList = new BoardList();

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);

    boardList.add(board);

    System.out.println("저장하였습니다.");
  }

  public void listBoard() {
    boardList.toArray();
  }

}//////////////////////////
