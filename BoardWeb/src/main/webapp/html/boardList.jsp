<%@page import="oracle.security.crypto.cert.ext.IssuerAltNameExtension"%>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글목록(boardList.jsp)</h3>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
%>
<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option value="">선택하세요</option>
				<option value="T">제목</option>
				<option value="W">작성자</option>
				<option value="TW">제목 & 작성자</option>
			</select>
		</div>
		<div class="col-sm-6">
			<input type="text" name="keyword" class="form-control">
		</div>
		<div class="col">
			<input type="submit" value="검색" class="form-control">
		</div>
	</div>
</form>
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
<!-- paging. -->
<%
PageDTO paging = (PageDTO) request.getAttribute("paging");
%>
<p><%=paging%></p>
<nav aria-label="...">
	<ul class="pagination">
		<%
		if (paging.isPrev()) {
		%>
		<li class="page-item"><a class="page-link"
			href="boardList.do?page=<%=paging.getStartPage() - 1%>">Previous</a></li>
		<%
		} else {
		%>
		<li class="page-item disabled"><span class="page-link">Previous</span>
		</li>
		<%
		}
		// startPage와 endPage의 값에 해당하는 링크를 반복적으로 생성.
		for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {
		// 출력하는 페이지와 현재페이지가 같으면 링크생략.
		if (paging.getCurrentPage() == p) {
		%>
		<li class="page-item active" aria-current="page"><span
			class="page-link"><%=p%></span></li>
		<%
		} else {
		%>
		<li class="page-item"><a class="page-link"
			href="boardList.do?page=<%=p%>"><%=p%></a></li>
		<%
		}
		}
		%>
		<%
		if (paging.isNext()) {
		%>
		<li class="page-item"><a class="page-link"
			href="boardList.do?page=<%=paging.getEndPage() + 1%>">Next</a></li>
		<%
		} else {
		%>
		<li class="page-item disabled"><span class="page-link">Next</span>
		</li>
		<%
		}
		%>
	</ul>
</nav>
<!-- paging. -->
<jsp:include page="../includes/footer.jsp"></jsp:include>