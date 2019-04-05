<%@page import="com.eomcs.lms.domain.PhotoFile"%>
<%@page import="java.util.List"%>
<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<%
  PhotoBoard photoBoard = (PhotoBoard) request.getAttribute("photoBoard");
  List<Lesson> lessonList = (List<Lesson>) request.getAttribute("lessons");
  List<PhotoFile> files = (List<PhotoFile>) request.getAttribute("photoFile");
%>
<html>
<head>
<title>사진 조회(JPS)</title>
<%if (photoBoard == null) { %>
<p>해당 게시물이 없습니다</p>
<%} else { %>
</head>

<body>
  <jsp:include page="/header.jsp" />

  <h1>사진 조회(JSP)</h1>
  <form action='update' method='post' enctype='multipart/form-data'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input name='no' value='<%=photoBoard.getNo() %>' readonly></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input name='title' value='<%=photoBoard.getTitle() %>'></td>
      </tr>
      <tr>
        <th>등록일</th>
        <td><%=photoBoard.getCreatedDate() %></td>
      </tr>
      <tr>
        <th>조회수</th>
        <td><%=photoBoard.getViewCount()%></td>
      </tr>
      <tr>
        <th>수업</th>
        <td><select name='lessonNo'>
            <% for (Lesson lesson : lessonList) {%>
            <option value='<%=lesson.getNo() %>'><%=lesson.getTitle() %>(<%=lesson.getStartDate() %> ~ <%=lesson.getEndDate() %>)</option>
            <%} %>
        </select></td>
      </tr>
      <tr>
        <td colspan='2'>최소 한 개의 사진 파일을 등록해야 합니다.</td>
      </tr>
      <tr>
        <th>사진1</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진2</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진3</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진4</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진5</th>
        <td><input type='file' name='photo'></td>
      </tr>
<tr>
  <th>사진</th>
  <td>
  <% for (PhotoFile file : files) {%>
<img src='../upload/photoboard/<%=file.getFilePath() %>' style='height:80px'>
<%} %>
</td></tr>
    </table>
    <p>
      <a href='list'>목록</a> <a href='delete?no=<%=photoBoard.getNo() %>'>삭제</a>
      <button type='submit'>변경</button>
    <p>
  </form>
  <% } %>
</body>
</html>
