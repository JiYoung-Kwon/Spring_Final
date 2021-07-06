<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="./notice/notice.css">
<script src="./notice/jquery/jquery.js"></script>

</head>
<body>
	<div id="unotice_reader_form">
		<div id="unotice_header_frm">공지사항</div>
		
		<form id="unotice_search_frm" name="unotice_search_frm" method="post" action="" onsubmit="return false">
			<div id="unotice_total">총 <span>${page.totList}</span>건</div>
			<select id="unotice_sort" name="findSort">
				<option value="제목"<c:if test="${page.findSort eq '제목'}">selected="selected"</c:if>>제목</option>
				<option value="내용"<c:if test="${page.findSort eq '내용'}">selected="selected"</c:if>>내용</option>
			</select>
			<div id="unotice_search">
				<input id="unotice_findstr" name="findStr" type="text" value="${page.findStr}" onkeyup="UNoticeEnterAction(event)">
				<input id="unotice_findbtn" name="unotice_findbtn" type="button" onclick="UNoticeClickAction()">
			</div>
			
			<input id="nowPage" name="nowPage" type="hidden" value="${(empty page.nowPage) ? 1 : page.nowPage}">
			<input id="serial" name="serial" type="hidden" value="${param.serial}">
		</form>
		
		<form id="unotice_board_frm" name="unotice_board_frm" method="post" action="" onsubmit="return false">
			<div class="unotice_item">
				<span>번호</span>
				<span>제목</span>
				<span>작성자</span>
				<span>작성일</span>
				<span>조회수</span>
			</div>
			<c:forEach var="list" items="${list}">
			<div class="unotice_items" onclick="UNoticeView(${list.serial})">
				<span>${list.rno}</span>
				<span>${list.title}</span>
				<span>${list.mid}</span>
				<span>${list.mdate}</span>
				<span>${list.hit}</span>
			</div>
			</c:forEach>
			<c:if test="${page.totList == 0}">
			<div class="unotice_items">
				<span>데이터를 찾을수 없습니다.</span>
			</div>
			</c:if>
		</form>
		
		<div id="unotice_footer_frm">
			<div id="unotice_previous">
				<c:if test="${page.nowPage>1}">
				<input type="button" onclick="UNoticePageMove(${(page.nowPage - page.nowPage) + 1})">
				<input type="button" onclick="UNoticePageMove(${page.nowPage - 1})">
				</c:if>
			</div>
			
			<div id="unotice_center">
				<c:forEach var="p" begin="${page.startPage}" end="${page.endPage}">
				<input type="button" value="${p}" onclick="UNoticePageMove(${p})" <c:if test="${p eq page.nowPage}">style='font-size:20pt; color:#13669b;'</c:if>>
				</c:forEach>
			</div>
			
			<div id="unotice_next">
				<c:if test="${page.nowPage<page.totPage}">
				<input type="button" onclick="UNoticePageMove(${page.nowPage + 1})">
				<input type="button" onclick="UNoticePageMove(${page.totPage})">
				</c:if>
			</div>
		</div>
	</div>
	
	<script src="./notice/notice.js"></script>
</body>
</html>