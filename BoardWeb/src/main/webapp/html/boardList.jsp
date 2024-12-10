<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글목록(boardList.jsp)</h3>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
%>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일지</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO bvo : list) {
		%>
		<tr>
			<th><a href="board.do?board_no=<%=bvo.getBoardNo()%>"><%=bvo.getBoardNo()%></th>
			<th><%=bvo.getTitle()%></th>
			<th><%=bvo.getWriter()%></th>
			<th><%=bvo.getCreationDate()%></th>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>