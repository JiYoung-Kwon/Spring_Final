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
	<div id="unotice_view_form">
		<div id="unotice_header_frm">코로나 관련보도</div>
		<form id="unotice_view_frm" name="unotice_view_frm" method="post" action="">
			<div id="unotice_section1">
				<div id="unotice_title">${vo.title}</div>
			</div>
			<div id="unotice_section2">
				<div id="unotice_information"><span>담당 : </span>${vo.mid}<span id="unotice_width">-</span><span>작성일 : </span>${vo.mdate}</div>
			</div>
			<div id="unotice_section3">
				${vo.doc}
			</div>
			
			<input id="nowPage" name="nowPage" type="hidden" value="${page.nowPage}">
			<input id="findStr" name="findStr" type="hidden" value="${page.findStr}">
			<input id="findSort" name="findSort" type="hidden" value="${page.findSort}">
		</form>
		<div id="unotice_footer_frm">
			<input id="unotice_back" name="unotice_back" type="button" value="목록으로" onclick="UNoticeViewBack()">
		</div>
	</div>
	
	<script src="./notice/notice.js"></script>
</body>
</html>