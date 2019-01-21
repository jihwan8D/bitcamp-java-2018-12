package bitcamp.lms.handle;

import bitcamp.lms.App;
import bitcamp.lms.domain.Board;

public class BoardList {
  static final int LENGTH = 3;
  Board[] boards = new Board[LENGTH];
  int boardIdx = 0;

  public Board[] toArray() {
    
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].getNo(), boards[j].getContents(), boards[j].getCreatedDate(), boards[j].getViewCount());
    }
    return null;
  }

  public void add(Board board) {
    if(boardIdx == boards.length) {
      Board[] a = new Board[boards.length + boards.length >> 1];
      for (int i = 0; i<boards.length; i++) {
        a[i] = boards[i];
      }
      boards = a;
    }
    
    boards[boardIdx++] = board;
    

  }
}
///////////////////////