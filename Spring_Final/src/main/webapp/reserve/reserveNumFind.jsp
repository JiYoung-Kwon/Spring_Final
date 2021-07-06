<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<script src='/Spring_Final/reservejs/reserve.js'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>예약번호 찾기</title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:200px;
}

input[type=text]:focus::placeholder{
color: transparent;
}
</style>
<body>
<h2>예약번호 찾기</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<div>
			<div>접종자 확인 | 예약번호 안내</div>
		</div>
		<br/>
		
		<label>접종 받는 분 이름</label>
		<input type='text' name='myName' id='myName' placeholder="홍길동"/>
		<hr/>
		
		<label>접종 받는 분 전화번호</label>
		<input type='text' name='myPhone' id='myPhone' placeholder="010-0000-0000" maxlength="13"/>
		<hr/>
		
		<label>주민등록 번호</label>
		<input type='text' name='myJumin' id='myJumin' placeholder="000000-0000000" maxlength="14"/>

		<input type='button' id='btnFindR' value='예약번호 찾기'/>
		<input type='button' value='뒤로가기' onclick="$('#middle').load('./sc.reserve');"/>
		<hr/>
	
	</form>
</div>
<script>
reserve.init();
reserve.mykeyup();
</script>
</body>
</html>