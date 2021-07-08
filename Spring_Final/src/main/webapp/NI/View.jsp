<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
<link rel='stylesheet' type='text/css' href='./NIcss/View.css'>
<script src="./NIjs/jquery-3.6.0.min.js" ></script>
<script src='./NIjs/NIboarder.js'></script>
</head>
<body>
	<div id="View">
		<div id="View_header">코로나 관련보도</div>
		
		<form id="View_frm" name="View_frm" >
			<div id="View_section1">
				<label id="View_title">${vo.title }</label>
			</div>
			<div id="View_section2">
				<label id="View_id">담당 : ${vo.mId }</label>
				<output> - </output>
				<label id="View_date">작성일 : ${vo.mDate }</label>
			</div>
			<div id="View_section3">
				${vo.doc }
			</div>
			
			<input id="tabGubun" name="tabGubun" type="hidden" value="${page.tabGubun }">
			<input id="nowPage" name="nowPage" type="hidden" value="${page.nowPage}">
			<input id="findStr" name="findStr" type="hidden" value="${page.findStr}">
			<input id="findSort" name="findSort" type="hidden" value="${page.findSort}">
			<input id="serial" name="serial" type="hidden" value="${vo.serial}">
			
		</form>
		
		<div id="View_back">
			<input id="View_backbtn" name="View_backbtn" type="button" value="목록" onclick='brd.back() ' >
		</div>
	</div>
</body>

</html>