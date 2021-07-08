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
<title>조회/취소</title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:200px;
}

input[type=text]:focus::placeholder{
color: transparent;
}
h2 {
    font-size: 36px;
    color: #0068b7;
}
button {
    cursor: pointer;
}
.btn {
    min-width: 80px;
    height: 40px;
    padding: 0 20px;
    border-radius: 4px;
    border: none;
    outline: none;
    font-size: 18px;
    font-weight: 400;
    letter-spacing: -0.075em;
}

.btn.wide2 {
    width: 150px;
}
.orange {
    background-color: #ff9d00;
    color: #fff;
}

.btn.blue {
    background-color: #0068b7;
    color: #fff;
}
.btn.white {
    background-color: #fff;
    border: 1px solid #e9ebf5;
    color: #666;
}
</style>
<body>
<h2>예약 조회/취소</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<div>
			<div>1단계 | 본인인증 및 예약여부 확인</div>
			<div>2단계 | 예약정보 조회</div>
		</div>
		<br/>
		
		<label>접종 받는 분 이름</label>
		<input type='text' name='myName' id='myName' placeholder="홍길동"/>
		<hr/>
		
		<label>접종 받는 분 전화번호</label>
		<input type='text' name='myPhone' id='reservePhone' placeholder="010-0000-0000" maxlength="13"/>
		<hr/>
		
		<label>예약 번호</label>
		<input type='text' name='reserveNum' id='reserveNum'/>

		<input type='button' id='btnSearch' class="btn blue wide"  value='조회하기'/>
		<input type='button' id='btnFind' class='btn wide2 orange' value='예약번호 찾기'/>
		<input type='button' value='취소' class="btn white homeBtn" onclick="$('#middle').load('./doReserve.reserve');"/>
		<hr/>
	
	</form>
</div>
<script>
reserve.init();
reserve.mykeyupchk();
</script>
</body>
</html>