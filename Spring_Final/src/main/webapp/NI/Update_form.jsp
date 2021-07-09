<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel='stylesheet' type='text/css' href='../../NIcss/Update_form.css'>
<script src="../../NIjs/jquery-3.6.0.min.js" ></script>
<script src="../../NIjs/Manager.js"></script>
<script src="../../textarea/demo/js/service/HuskyEZCreator.js"></script>

</head>
<body>
	<form id="Update_form" name="Update_form" method="post" action="">
		<div id="Update_header_frm">
			<div id="Update_title1">제목</div>
			<input id="Update_title2" name="title" type="text" value="${vo.title}">
		</div>
		
		<div id="Update_section_frm">
			<textarea id="Update_create_area" name="doc">${vo.doc}</textarea>
		</div>
		
		<div id="Update_footer_frm">
			<input id="Update" name="Update" type="button" value="수정" >
			<input id="Update_delete" name="Update_delete" type="button" value="삭제" >
			<input id="Update_back" name="Update_back" type="button" value="닫기" >
		</div>
		
		<div id="Update_ok">
			<div id="ask">정말 수정하시겠습니까?</div>
			<input id="update_yes" name="update_yes" type="button" value="YES">
			<input id="update_no" name="update_no" type="button" value="NO">
		</div>
		
		<div id="Update_delete_ok">
			<div id="ask">정말 삭제하시겠습니까?</div>
			<input id="delete_yes" name="delete_yes" type="button" value="YES">
			<input id="delete_no" name="delete_no" type="button" value="NO">
		</div>
		
		<input id="nowPage" name="nowPage" type="hidden" value="${page.nowPage}">
		<input id="findStr" name="findStr" type="hidden" value="${page.findStr}">
		<input id="findSort" name="findSort" type="hidden" value="${page.findSort}">
		<input id="serial" name="serial" type="hidden" value="${vo.serial}">
		<input id="tabGubun" name="tabGubun" type="hidden" value='${param.tabGubun}'>
	</form>
	
	
	
</body>
<script> brd.init(); </script>
<script src="../../NIjs/editor2.js"></script>
<script src="../../NIjs/NIboarder.js"></script>
</html>