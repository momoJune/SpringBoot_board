<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- 공통코드 삽입 --%>
<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html lang="ko">

<head>

    <title>Qna</title>
<%-- 부트스트랩을 사용하기 위한 준비 시작 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- 부트스트랩을 사용하기 위한 준비 끝 --%>
	
<style type="text/css">
	table { width: 1000px; margin: auto; padding: 5px;}
	th {padding: 5px; border: 1px solid gray; background-color: silver;text-align: center;}
	td {padding: 5px; border: 1px solid gray; text-align: center;}
	.title {border: none; font-size: 20pt; text-align: center;}
	.sub_title {border: none; text-align: right;}
	/* 링크의 모양을 변경한다. */
	a:link 		{ color: black; text-decoration: none;} /* 링크가 걸린모양 */
	a:visited 	{ color: black; text-decoration: none;} /* 방문했던 링크 */
	a:hover 	{ color: black; text-decoration: none; font-weight: bold;} /* 마우스오버시 모양 */
	a:active 	{ color: orange; text-decoration: none;} /* 마우스 클릭시 모양 */
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="6" class="title">
				자 유 게 시 판
			</td>
		</tr>
		<tr>
			<td colspan="6" class="sub_title">
				${pv.pageInfo }
			</td>
		</tr>
		<tr>
			<th>No</th>
			<th width="55%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>날짜</th>
		</tr>
			<c:forEach var="vo" items="${boardList }" >
				<tr align="center">
					<td>${vo.idx}</td>
					<td>
						<c:out value="${vo.writer }"></c:out>
					</td>
					<td>
						<c:out value="${vo.title}"></c:out>
					</td>
					<td>
						<c:out value="${vo.content}"></c:out>
					</td>
					<td>
						<fmt:formatDate value="${vo.regDate }" pattern="yyyy-MM-dd"/>
					</td>
					<%-- 
					<td  style="background-color: #F2F2F2">
						<c:if test="${vo.back_Qna_Reply_Content != null }" >
							<c:out value="${vo.back_Qna_Reply_Content}"></c:out>
						</c:if>
						<c:if test="${vo.back_Qna_Reply_Content == null }" >
							<c:out value="아직 답변이 없습니다." ></c:out>
						</c:if>
					</td>
					 --%>
				</tr>	
			</c:forEach>
		<tr>
		<td class="sub_title" colspan="6">
				<button class="btn btn-outline-success btn-sm" onclick="location.href='boardInsert' ">새글쓰기</button>
			</td>
		</tr>
	</table>	            
</body>

</html>