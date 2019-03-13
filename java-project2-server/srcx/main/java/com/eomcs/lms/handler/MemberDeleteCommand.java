package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;

public class MemberDeleteCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public MemberDeleteCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
      MemberDao memberDao = sqlSession.getMapper(MemberDao.class);

      int no = response.requestInt("번호?");

      if (memberDao.delete(no) == 0) {
        response.println("해당 번호의 회원이 없습니다.");
        return;
      }
      sqlSession.commit();
      response.println("삭제했습니다.");
    }
  }
}