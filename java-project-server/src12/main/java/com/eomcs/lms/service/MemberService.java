package com.eomcs.lms.service;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberService extends AbstractService<Member> {

  // MemberService가 작업을 수행할 때 사용할 객체(의존 객체; dependency)
  MemberDao memberDao;
  
  public MemberService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  
  public void execute(String request) throws Exception {

    switch (request) {
      case "/member/add":
        add();
        break;
      case "/member/list":
        list();
        break;
      case "/member/detail":
        detail();
        break;
      case "/member/update":
        update();
        break;
      case "/member/delete":
        delete();
        break;  
      default:
        out.writeUTF("FAIL");
    }
    out.flush();
  }

  private void add() throws Exception {
    out.writeUTF("OK");
    out.flush();
    memberDao.insert((Member)in.readObject());
    out.writeUTF("OK");
  }

  private void list() throws Exception {
    out.writeUTF("OK");
    out.flush();
    out.writeUTF("OK");
    out.writeUnshared(memberDao.findAll());
  }

  private void detail() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    Member b = memberDao.findByNo(no);
    if (b == null) { 
      out.writeUTF("FAIL");
      return;
    }

    out.writeUTF("OK");
    out.writeObject(b);
  }

  private void update() throws Exception {
    out.writeUTF("OK");
    out.flush();
    Member member = (Member) in.readObject();

    if (memberDao.update(member) == 0) {
      out.writeUTF("FAIL");
      return;
    }
    
    out.writeUTF("OK");
  }

  private void delete() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    if (memberDao.delete(no) == 0) {
      out.writeUTF("FAIL");    
      return;
    }
    
    out.writeUTF("OK");
  }

}







