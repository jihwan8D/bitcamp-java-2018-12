package bitcamp.lms.handle;

import bitcamp.lms.domain.Board;

public class BoardList {
  static final int LENGTH = 3;
  Board[] arr = new Board[LENGTH];
  int boardIdx = 0;

  public Board[] toArray() {
    
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          arr[j].getNo(), arr[j].getContents(), arr[j].getCreatedDate(), arr[j].getViewCount());
    }
    return null;
  }

  public void add(Board board) {
    if(boardIdx == arr.length) {
      Board[] a = new Board[arr.length + arr.length >> 1];
      for (int i = 0; i<arr.length; i++) {
        a[i] = arr[i];
      }
      arr = a;
    }
    
    arr[boardIdx++] = board;
    

  }
}
///////////////////////