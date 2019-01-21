package bitcamp.lms.handle;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.App;
import bitcamp.lms.domain.Member;

public class MemberHandler {

  public Scanner keyboard;

  public MemberHandler (Scanner keyboard){
    this.keyboard = keyboard;
  }

  Member[] members = new Member[App.LENGTH];

  int memberIdx = 0;

  public void listMember() {
    for (int j = 0; j < memberIdx; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          members[j].getNo(), members[j].getName(), members[j].getEmail(), 
          members[j].getTel(), members[j].getRegisteredDate());
    }
  }

  public void addmember() {

    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("이름? ");
    member.setName(keyboard.nextLine());

    System.out.print("이메일? ");
    member.setEmail(keyboard.nextLine());

    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine());

    System.out.print("사진? ");
    member.setPhoto(keyboard.nextLine());

    System.out.print("전화? ");
    member.setTel(keyboard.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis())); 

    members[memberIdx] = member;
    memberIdx++;

    System.out.println("저장하였습니다.");
  }
}
