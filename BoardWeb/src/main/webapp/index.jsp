<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.jdbc.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <jsp:forward page="boardList.do"></jsp:forward>
  <%
  // 주석처리.
  String msg = "Hello";
  System.out.println(msg);
  %>
  <p>변수에 담긴 값은 <%=msg %></p>
  
  <%
  BoardDAO bdao = new BoardDAO();
  List<BoardVO> list = bdao.boardList();
  
  for (BoardVO board : list) {
  %>
  <p>글번호:<%=board.getBoardNo() %> 제목:<%=board.getTitle() %> 내용:<%=board.getContent() %> 작성자:<%=board.getWriter() %></p>
  <%} %>
</body>
</html>