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
<title>예약 취소</title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:200px;
}
</style>
<body>
<h2>예약취소</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<div>
			<div>백신예약을 정말 취소 하시겠습니까?</div>
		</div>
		<br/>
		
		<label>접종 받는 분 이름</label>
		<input type='text' name='myName' id='myName' placeholder="홍길동"/>
		<hr/>
		
		<label>접종 받는 분 전화번호</label>
		<input type='text' name='myPhone' id='myPhone' placeholder="010-0000-0000" maxlength="13"/>
		<hr/>
		
		<label>예약 번호</label>
		<input type='text' name='reserveNum' id='reserveNum'/>

		<input type='button' id='btnCancleR' value='예약 취소'/>
		<input type='button' id='btnSearch' value='조회 화면'/>
		<hr/>
	
	</form>
</div>
<script>reserve.init();</script>
</body>
</html>