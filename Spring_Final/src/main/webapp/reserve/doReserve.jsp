<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>예약하기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='/Spring_Final/reservejs/reserve.js'></script>
</head>
<style>
#reserve #btnMyReserve, #btnOtherReserve{
 width:300px;height:200px;font-size:20px;
}

</style>
<body>
<h2>예약하기</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<h3>예약 종류를 선택하여 주세요</h3>
		<span>코로나 19 예방접종의 경우 본인 예약과 대리 예약을 할 수 있습니다. 원하시는 방법을 선택하여 주세요.</span>
		<hr/>
		<input type='button' id='btnMyReserve' value='코로나19 예방접종 본인 예약'/>
		<input type='button' id='btnOtherReserve' value='코로나19 예방접종 대리 예약'/>
		<hr/>
		<span>대리 예약의 경우에도 본인 인증 수단이 필요합니다. 대리 예약 하여 주시는 분의 휴대폰 또는 E-mail을 준비하여 주세요.</span>
	</form>
</div>
<script>reserve.init();</script>
</body>
</html>