<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 폼</title>

<link rel="stylesheet" href="../NIcss/Create.css">
<script src="../NIjs/jquery-3.6.0.min.js" ></script>
<script src="../NIjs/Manager.js"></script>
<script src="../textarea/demo/js/service/HuskyEZCreator.js"></script>

</head>
<body>
	<form id="Create_form" name="Create_form" method="post" action="">
		<div id="Create_header_frm">
		
			<div id="Create_title1">제목</div>
			
			
			<input id="Create_title2" name="title" type="text">
			
		</div>
		
		<div id="Create_section_frm">
			<textarea id="Create_area" name="doc">
			
			
			
			</textarea>
		</div>
		
		<div id="Create_footer_frm">
			<input id="Create_save" name="Create_save" type="button" value="저장" >
			<input id="Create_back" name="Create_back" type="button" value="닫기">
		</div>
		
		
		<input id="tabGubun" name="tabGubun" type="hidden" value='${param.tabGubun}'>
		
		
		
		</form>
		
		
	
	
		
	
</body>
<script> brd.init(); 
		imageView('attfile', 'attzone');
</script>
<script src="../js/editor.js"></script>
<script src="../js/NIboarder.js"></script>
</html>