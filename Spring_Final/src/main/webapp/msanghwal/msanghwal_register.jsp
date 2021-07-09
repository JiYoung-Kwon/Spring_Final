<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>관리자 생활속 방역수칙 입력게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../../smarteditor/demo/js/service/HuskyEZCreator.js"></script>

<link rel='StyleSheet' type='text/css' href='../../css/msang.css'>
</head>
<body>
	<div id='sang'>
		<form name='frm_sang' id='frm_sang' method='POST' action=''
			onsubmit="return false">
			<h1>생활속 방역 수칙 작성</h1>
			<div id='insertform'>
				<div id='titleform'>
					<label id='ltitle'>제목</label> 
					<input type='text' id='title' name='title' />
				</div>

				<div id="registerform">
					<textarea id="sanghwalarea" name="doc"></textarea>
				</div>
			</div>
		</form>
		<form name='frm_upload' id='frm_upload' method='POST' action=''>
			<label>첨부파일</label> 
			<input type='file' name='attfile' id='attfile' multiple />
			<div id='image_preview'>
				<div id='attzone'></div>
			</div>
		</form>

		<div id='registerbtn_zone'>
			<input id="btnInsertR" name="btnInsertR" type="button" value="저장" />
			<input id="btnSearch" name="btnSearch" type="button" value="닫기" />
		</div>
	</div>

	<script src='../../js/msanghwaleditor.js'></script>
	<script src='../../js/msanghwal.js'></script>
	<script>
  sang.init();
  imageView('attfile', 'attzone');
</script>
</body>
</html>