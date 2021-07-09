<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>관리자 생활속 방역수칙 수정게시판</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../../smarteditor/demo/js/service/HuskyEZCreator.js"></script>
</head>
<body>
	<div id='sang'>
		<form name='frm_sang' id='frm_sang' method='POST' action=''
			onsubmit="return false">
			<h1>생활속 방역 수칙 수정</h1>
			<div id='insertform'>
				<div id='titleform'>
					<label id='ltitle'>제목</label> <input type='text' id='title'
						name='title' value='${vo.title }'/>
				</div>

				<div id="registerform">
					<textarea id="sanghwalarea" name="doc" >${vo.doc }</textarea>
				</div>
			</div>
			<input type='hidden' name='nowPage' value='${param.nowPage }' /> 
			    <input type='hidden' name='findStr' value='${param.findStr }' /> 
			    <input type='hidden' name='serial' value='${param.serial }' />
		</form>
		
		<form name='frm_upload' id='frm_upload' method='POST' action=''>
			<label>첨부파일</label> 
			<input type='file' name='attfile' id='attfile' multiple />
			<div id='image_preview'>
			<div id='attzone'>
			<c:forEach var='f' items="${vo2.attList}">
					<img src="../../upload/${f.sysAtt }"  width='150px' height='180px'/>
					<label  class='del_file_chk'>
						<input type='checkbox' class='delFile' name='delFile' value='${f.sysAtt }'>삭제</label> 
			</c:forEach>
			</div></div>
			    <input type='hidden' name='serial' value='${param.serial }' />
		</form>
		
				<div id='updatebtn_zone'>
					<input type='button' id='btnUpdate' value='수정' /> 
					<input type='button' id='btnDelete' value='삭제' /> 
					<input type='button' id='btnSearch' value='닫기' />
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