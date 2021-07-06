<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="./notice.css">
<script src="./jquery/jquery.js"></script>

<script src="./smarteditor/demo/js/service/HuskyEZCreator.js"></script>

</head>
<body>
	<form id="mnotice_update_form" name="mnotice_update_form" method="post" action="">
		<div id="mnotice_header_frm">
			<div id="mnotice_title1">제목</div>
			<input id="mnotice_title2" name="title" type="text" value="${vo.title}">
		</div>
		<div id="mnotice_section_frm">
			<textarea id="mnotice_create_area" name="doc">${vo.doc}</textarea>
		</div>
		<div id="mnotice_footer_frm">
			<input id="mnotice_update" name="mnotice_update" type="button" value="수정" onclick="MNoticeUpdate()">
			<input id="mnotice_delete" name="mnotice_delete" type="button" value="삭제" onclick="MNoticeDelete()">
			<input id="mnotice_back" name="mnotice_back" type="button" value="닫기" onclick="MNoticeViewBack()">
		</div>
		<div id="mnotice_update_ok">
			<div id="ask">정말 수정하시겠습니까?</div>
			<input id="update_yes" name="update_yes" type="button" value="YES">
			<input id="update_no" name="update_no" type="button" value="NO">
		</div>
		<div id="mnotice_delete_ok">
			<div id="ask">정말 삭제하시겠습니까?</div>
			<input id="delete_yes" name="delete_yes" type="button" value="YES">
			<input id="delete_no" name="delete_no" type="button" value="NO">
		</div>
		
		<input id="nowPage" name="nowPage" type="hidden" value="${page.nowPage}">
		<input id="findStr" name="findStr" type="hidden" value="${page.findStr}">
		<input id="findSort" name="findSort" type="hidden" value="${page.findSort}">
		<input id="serial" name="serial" type="hidden" value="${vo.serial}">
	</form>
	
	<script src="./notice.js"></script>
	<script src="./editor.js"></script>
</body>
</html>