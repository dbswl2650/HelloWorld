<%@ page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글상세화면(board.jsp)</h3>

<form action="modifyForm.do">
	<input type="hidden" name="board_no" value="${board.boardNo}">
	<!-- 파라미터 추가작업. 2024.12.12 -->
	<input type="hidden" name="searchCondition"
		value="${searchCondition}"> <input type="hidden"
		name="keyword" value="${keyword}"> <input type="hidden"
		name="page" value="${page}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><c:out value="${board.boardNo }" /></td>
			<th>작성자</th>
			<td><c:out value="${board.writer }" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colsapn="3"><c:out value="${board.title }" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea rows="5" class="form-control" readonly
					name="content"><c:out value="${board.content }" /></textarea></td>
		</tr>
		<tr>
			<th>작성일지</th>
			<td><c:out value="${board.creationDate }" /></td>
			<th>조회수</th>
			<td><c:out value="${board.viewCnt }" /></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><c:choose>
					<c:when test="${!empty logId && logId eq board.writer }">
						<input type="submit" class="btn btn-warning" value="수정화면">
					</c:when>
					<c:otherwise>
						<input disabled type="submit" class="btn btn-danger" value="수정화면">
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>