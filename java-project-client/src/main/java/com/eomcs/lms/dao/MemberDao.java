// 데이터 처리 관련 코드를 별도의 클래스로 분리
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {

  void insert(Member member);
  List<Member> findAll();
  Member findByNo(int no);
  int update(Member member);
  int delete(int no);
}







