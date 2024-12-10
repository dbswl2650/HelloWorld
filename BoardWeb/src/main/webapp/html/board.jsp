<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글상세화면(board.jsp)</h3>
<%
BoardVO bvo = (BoardVO) request.getAttribute("board");
%>
<form action="modifyForm.do">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=bvo.getBoardNo()%></td>
			<th>작성자</th>
			<td><%=bvo.getWriter()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colsapn="3"><%=bvo.getTitle()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td class= "form-control"><%=bvo.getContent()%></td>
		</tr>
		<tr>
			<th>작성일지</th>
			<td><%=bvo.getCreationDate()%></td>
			<th>조회수</th>
			<td><%=bvo.getViewCnt()%></td>
		</tr>
		<tr>
		  <td colspan="4" align = "center">
		    <input type="submit" class= "btn btn-warning" value="수정화면">
		  </td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>