package com.eomcs.lms.handler;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.proxy.MemberProxy;

public class MemberListCommand implements Command {
  
  Scanner keyboard;
  MemberProxy memberProxy;
  
  public MemberListCommand(Scanner keyboard, MemberProxy memberAgent) {
    this.keyboard = keyboard;
    this.memberProxy = memberAgent;
  }
  
  @Override
  public void execute() {
    try {
      List<Member> members = memberProxy.findAll();
      for (Member member : members) {
        System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
            member.getNo(), member.getName(), 
            member.getEmail(), member.getTel(), member.getRegisteredDate());
      }
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
