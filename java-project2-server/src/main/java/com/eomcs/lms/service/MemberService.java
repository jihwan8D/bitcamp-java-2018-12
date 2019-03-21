package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberService {
  List<Member> list();
  int add(Member board);
  Member get(int no);
  int update(Member board);
  int delete(int no);
  List<Member> search(String keyword);
}
