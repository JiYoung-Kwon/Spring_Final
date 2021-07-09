<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>관리자 생활 방역 게시판 조회</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='../../js/msanghwal.js'></script>

<link rel='StyleSheet' type='text/css' href='../../css/msang.css'>
</head>
<body>
	<div id='sang'>
		<form name='frm_sang' id='frm_sang' class='frm_sang' method='post'
			action='' onsubmit="return false">
			<div id='head'>
				<label id='subject'><h1>생활속 방역 수칙</h1></label><br />
			</div>
			<input id="nowPage" name="nowPage" type="hidden"
				value="${(empty param.nowPage) ? 1 : param.nowPage}" />	
			<input id="serial" name="serial" type="hidden" value="${param.serial}" />
		
			<div id='find'>
			  <select id="sanghwal_sort" name='gubun'>
			  <option value="sanghwal_basic" <c:if test="${page.gubun eq 'sanghwal_basic'}">selected = "selected"</c:if>>제목</option>
			  <option value="sanghwal_doc" <c:if test="${page.gubun eq 'sanghwal_doc'}">selected = "selected"</c:if>>내용</option>
		      </select>
				<input type='text' name='findStr' id='findStr' value='${param.findStr}' /> 
				<input type='button' id='btnFind' value='검색'/>
			</div>
			<!-- serial값을 저장하고 보내는 히든값 -->
			<div id='items'>
				<c:forEach var='vo' items="${list}">
					<div class='item' onclick='sang.update(${vo.serial})'>
						<img src="../../upload/${vo.nail }" class='photo' /><br /> 
						<span class='title'><h2>${vo.title}</h2></span><br /> 
						<span class='mdate'>${vo.mdate }</span>
					</div>
				</c:forEach>
				
				<c:if test="${page.totList == 0 }">
				  <div id ="nop">
				   <span>존재하지 않는 검색어 입니다.</span>
				   </div>
				</c:if> 
			</div>
			
			<div id='insert_btn_zone'>
			  <input type='button' value='작성' id='btnInsert'/>
			</div>
			
			<br />
			<div id='btn_zone'>
				<c:if test="${page.nowPage>1 }">
					<input type='button' value='<<' onclick=' sang.move(1)'/>
					<input type='button' value='<' onclick=' sang.move(${page.nowPage-1 })'/>
				</c:if>
				<c:forEach var='p' begin='${page.startPage }' end='${page.endPage }'>
					<input type='button' value='${p }' onclick='sang.move(${p})' />
				</c:forEach>

				<c:if test="${page.endPage<page.totPage }">
					<input type='button' value='>'
						onclick='sang.move(${page.nowPage+1})' />
					<input type='button' value='>>'
						onclick='sang.move(${page.totPage})' />
				</c:if>

			</div>
		</form>
	</div>
	<script>
sang.init();
</script>
</body>
</html>