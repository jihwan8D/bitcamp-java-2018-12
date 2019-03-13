package com.eomcs.lms.handler;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberListCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public MemberListCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()) {

      MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
      
      List<Member> members = memberDao.findAll();
      for (Member member : members) {
        response.println(String.format("%3d, %-4s, %-20s, %-15s, %s", 
            member.getNo(), member.getName(), 
            member.getEmail(), member.getTel(), member.getRegisteredDate()));
      }
    }
  }
}
