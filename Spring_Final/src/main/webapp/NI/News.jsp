<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang = 'ko'>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel='stylesheet' type='text/css' href='./NIcss/NewsBoard.css'>
<script src="./NIjs/jquery-3.6.0.min.js" ></script>
<script src="./NIjs/NIboarder.js"></script>
<title>보도자료</title>
</head>
<body>
<div id = "News_Board">
	
 		
		<h1 id="News_header">코로나 관련 보도</h1>
		
		<div id ="News_menubtn_zone">
 		<input type='button' class='btn_issue' id='btn_issue' name='btn_issue' value="위험지역 이슈" onclick="tab('issue')" />
 		<input type='button' class='btn_news' id='btn_news' name='btn_news' value="코로나 관련 보도" onclick="tab('news')"/>
 		<input type='button' class='btn_hobby' id='btn_hobby' name='btn_hobby' value="이시국 취미생활" onclick="tab('hobby')" />
		</div>
		
		<form id="News_board_frm" name="News_frm" method="post" action="News.brd">
			<div id="News_total"> 총 ${page.totList } 건</div>
			<select id="News_sort">
				<option value="jacSung">제목</option>
				<option value="joHoe">내용</option>
			</select>
			<div id="News_searchbox">
				<input id="findStr" name='News_findbtn' type="text"  value="${page.findStr }">
				<input id="search"  type="button">
			</div>
			
			<input id="nowPage" name="nowPage" type="hidden" value='${(empty param.nowPage)? 1 : param.nowPage }'>
			<input id="tabGubun" name="tabGubun" type="hidden" value='${param.tabGubun}'>
			<input id="findStr" name="findStr" type="hidden" value='${param.findStr }'>
		</form>
		
		<form id="News_frm" name="News_frm" method="post" action="">
			<div class="News_item">
				<span>번호</span>
				<span>제목</span>
				<span>작성자</span>
				<span>작성일</span>
				<span>조회수</span>
			</div>
			
		<c:forEach var="list" items="${list}">
			<div class="News_items" onclick='brd.view(${list.serial})' >
				<span>${list.rno}</span>
				<span>${list.title}</span>
				<span>${list.mId}</span>
				<span>${list.mDate}</span>
				<span>${list.hit}</span>
			</div>
		</c:forEach>	
			
			
		</form>
		<div id="News_footer_frm">
		
		<div id="News_previous">
			<c:if test="${page.nowPage>1}">
				<input type='button' value='' onclick='brd.move(1)'/>
				<input type='button' value='' onclick='brd.move(${page.nowPage-1 })'/>
			</c:if>
			
			</div>
			
			<div id="News_center">
			<c:forEach var='p' begin='${page.startPage }' end='${page.endPage }'>
				<input type='button' value='${p }' onclick ='brd.move(${p})' />
			</c:forEach>
			
			</div>
			
			<div id="News_next">
			<c:if test="${page.nowPage<page.totPage }">
				<input type='button' value='' onclick ='brd.move(${page.nowPage+1})'/>
				<input type='button' value='' onclick ='brd.move(${page.totPage})'/>
			</c:if>
		</div>
</div>

</div>
	
	
</body>
<script> brd.init(); </script>
</html>