package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.proxy.MemberDaoProxy;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  MemberDaoProxy memberDao;
  
  public MemberDeleteCommand(Scanner keyboard, MemberDaoProxy memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    try {
      memberDao.delete(no);
      System.out.println("삭제했습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
