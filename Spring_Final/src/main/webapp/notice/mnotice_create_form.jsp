<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="/Spring_Final/notice/notice.css">
<script src="/Spring_Final/notice/jquery/jquery.js"></script>

<script src="/Spring_Final/notice/smarteditor/demo/js/service/HuskyEZCreator.js"></script>

</head>
<body>
	<form id="mnotice_create_form" name="mnotice_create_form" method="post" action="">
		<div id="mnotice_header_frm">
			<div id="mnotice_title1">제목</div>
			<input id="mnotice_title2" name="title" type="text">
		</div>
		<div id="mnotice_section_frm">
			<textarea id="mnotice_create_area" name="doc"></textarea>
		</div>
		<div id="mnotice_footer_frm">
			<input id="mnotice_save" name="mnotice_save" type="button" value="저장" onclick="MNoticeCreate()">
			<input id="mnotice_back" name="mnotice_back" type="button" value="닫기" onclick="MNoticeCreateBack()">
		</div>
		<div id="mnotice_create_ok">
			<div id="ask">정말 저장하시겠습니까?</div>
			<input id="create_yes" name="create_yes" type="button" value="YES">
			<input id="create_no" name="create_no" type="button" value="NO">
		</div>
		
		<input id="nowPage" name="nowPage" type="hidden" value="${page.nowPage}">
		<input id="findStr" name="findStr" type="hidden" value="${page.findStr}">
		<input id="findSort" name="findSort" type="hidden" value="${page.findSort}">
	</form>
	
	<script src="/Spring_Final/notice/notice.js"></script>
	<script src="/Spring_Final/notice/editor.js"></script>
</body>
</html>