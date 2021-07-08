<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang = 'ko'>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel='stylesheet' type='text/css' href='./NIcss/Issue_Manager.css'>
<title>위험지역 이슈(매니저)</title>
<script src="./NIjs/jquery-3.6.0.min.js" ></script>
<script src='./NIjs/Manager.js'></script>
</head>
<body>



<div id = "Issue_Board">S
	
 		
		<h1 id="Issue_header">위험지역 이슈</h1>
		
		<div id ="Issue_menubtn_zone">
 		<input type='button' class='btn_issue' id='btn_issue' name='btn_issue'  value="위험지역 이슈" onclick="tab('issue_M')" />
 		<input type='button' class='btn_news' id='btn_news' name='btn_issue' value="코로나 관련 보도"  onclick="tab('news_M')"/>
 		<input type='button' class='btn_hobby' id='btn_hobby' name='btn_issue' value="이시국 취미생활"  onclick="tab('hobby_M')"/>
		</div>
		
		<form id="Issue_board_frm" name="Issue_frm" method="post" action="">
			<div id="Issue_total"> 총 ${page.totList } 건</div>
			<select id="Issue_sort">
				<option value="jacSung">제목</option>
				<option value="joHoe">내용</option>
			</select>
			<div id="Issue_searchbox">
				<input id="findStr" name='Issue_findbtn' type="text" value="${page.findStr }">
				<input id="search"  type="button">
			</div>
			
			<input id="nowPage" name="nowPage" type="hidden" value='${(empty param.nowPage)? 1 : param.nowPage }'>
			<input id="tabGubun" name="tabGubun" type="hidden" value='${param.tabGubun}'>
		</form>
		
		
		
		<form id="Issue_frm" name="Issue_frm" method="post" action="">
			<div class="Issue_item">
				<span>번호</span>
				<span>제목</span>
				<span>작성자</span>
				<span>작성일</span>
				<span>조회수</span>
			</div>
			
		<c:forEach var="list" items="${list}">
			<div class="Issue_items" onclick="brd.view('${list.serial }')">
				<span>${list.rno}</span>
				<span>[이슈] ${list.title}</span>
				<span>${list.mId}</span>
				<span>${list.mDate}</span>
				<span>${list.hit}</span>
			</div>
		</c:forEach>	
			
		</form>
		
		<div id="Issue_footer_frm">
			<div id="Issue_previous">
			<c:if test="${page.nowPage>1}">
				<input type='button' value=' ' onclick='brd.move(1)'/>
				<input type='button' value=' ' onclick='brd.move(${page.nowPage-1 })'/>
			</c:if>
			
			</div>
			<div id="Issue_center">
			<c:forEach var='p' begin='${page.startPage }' end='${page.endPage }'>
				<input type='button' value='${p }' onclick ='brd.move(${p})' />
			</c:forEach>
			
			</div>
			<div id="Issue_next">
			<c:if test="${page.nowPage<page.totPage }">
				<input type='button' value=' ' onclick ='brd.move(${page.nowPage+1})'/>
				<input type='button' value=' ' onclick ='brd.move(${page.totPage})'/>
			</c:if>
			</div>
		</div>
		<div id="CreateM">
				<input type='button' id='Create' value='작성' >
		</div>
	</div>



</body>
<script> brd.init(); </script>
</html>