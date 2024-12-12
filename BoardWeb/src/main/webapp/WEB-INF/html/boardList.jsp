<%@page import="org.apache.jasper.tagplugins.jstl.core.Choose"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글목록(boardList.jsp)</h3>

<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option value="">선택하세요</option>
				<option value="T"
					${!empty searchCondition and serchCondition eq 'T' ? 'selected' : ''}>제목</option>
				<option value="W"
					${!empty searchCondition and serchCondition eq 'W' ? 'selected' : ''}>작성자</option>
				<option value="TW"
					${!empty searchCondition and serchCondition eq 'TW' ? 'selected' : ''}>제목
					& 작성자</option>
			</select>
		</div>
		<div class="col-sm-6">
			<input type="text" name="keyword"
				value="${!empty keyword ? keyword : ''}" class="form-control">
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
		<c:forEach var="bvo" items="${list }">
			<tr>
				<td><a
					href="board.do?page=${paging.currentPage}&keyword=${empty keyword ? '' :keyword }&searchCondition=${empty searchCondition ? '' :searchCondition }&board_no=${bvo.boardNo}">${bvo.boardNo}</a></td>
				<td><c:out value="${bvo.title}"/></td>
				<td><c:out value="${bvo.writer}"/></td>
				<td><c:out value="${bvo.creationDate}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- paging. -->
<nav aria-label="...">
	<ul class="pagination">
		<!-- 이전 10개 목록이 존재하면 previous를 활성화. -->
		<c:choose>
			<c:when test="${paging.prev}">
				<li class="page-item"><a class="page-link"
					href="boardList.do?page=${paging.startPage -1}&keyword=${empty keyword ? '' :keyword}&searchCondition=${empty searchCondition ? '' :searchCondition}">Previous
				</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">Previous</span>
				</li>
			</c:otherwise>
		</c:choose>
		<!-- startPage와 endPage의 값에 해당하는 링크를 반복적으로 생성. -->
		<c:forEach var="p" begin="${paging.startPage}"
			end="${paging.endPage}">
			<c:choose>
				<c:when test="${paging.currentPage == p}">
					<li class="page-item active" aria-current="page"><a
						class="page-link"
						href="boardList.do?keyword=${empty keyword ? '' : keyword}&searchCondition=${empty searchCondition ? '' : searchCondition }&page=${p }">${p }</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="boardList.do?keyword=${empty keyword ? '' : keyword}&searchCondition=${empty searchCondition ? '' : searchCondition }&page=${p }">${p }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${paging.next}">
				<li class="page-item"><a class="page-link"
					href="boardList.do?page=${paging.endPage +1}&keyword=${empty keyword?'':keyword}&searchCondition=${empty searchCondition?'':searchCondition}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">Next</span>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
<!-- paging. -->
<jsp:include page="../includes/footer.jsp"></jsp:include>