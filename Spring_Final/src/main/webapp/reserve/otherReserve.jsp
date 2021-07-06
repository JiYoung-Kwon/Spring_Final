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
<title>대리 예약</title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:200px;
}

input[type=text]:focus::placeholder{
color: transparent;
}

#reserve .btn{
	 width:150px;height:100px;font-size:20px;
}
</style>
<body>
<h2>대리 예약하기</h2>
<div id='reserve'>
	<form name='frm_otherReserve' id='frm_otherReserve' method='post' action=''>
		<div>
			<div>1단계 | 예약정보 입력</div>
			<div>2단계 | 예약완료 안내</div>
		</div>
		<br/>
		
		<div>
			<h3>개인정보 수집 및 이용에 대한 안내</h3>
			<p>「감염병의 예방 및 관리에 관한 법률」 제33조의 4 및 같은 법 시행령 제32조의 3에 따라 코로나19 예방접종 예약신청을 위하여 다음의 개인정보를 수집합니다</p>
		</div>
		
		<hr/>
		
		<label>대리 예약자 이름</label>
		<input type='text' name='otherName' id='otherName' placeholder="홍길동"/>
		<hr/>
		
		<label>대리 예약자 주민등록번호</label>
		<input type='text' name='otherJumin' id='otherJumin' placeholder="000000-0000000" maxlength="14"/>
		<hr/>
		
		<label>대리 예약자 본인인증</label>
		<input type='button' class='btn' id='btnSms' value='SMS 문자인증' onclick="smsPopup();"/>
		<input type='button' class='btn' id='btnEmail' value='e-mail 인증' onclick="emailPopup();"/>
		<br/>
		<label></label>
		<input type='text' id='reserveOk' name='reserveOk' value='인증을 완료하여 주세요' readonly/>
		<hr/>
		
		<label>대리 예약자 휴대폰 번호</label>
		<input type='text' name='otherPhone' id='otherPhone' placeholder="010-0000-0000" maxlength="13"/>
		<br/>
		<span>* 본인 명의의 휴대폰이 아닌경우 온라인 예약이 불가능합니다.</span>
		<hr/>
		
	</form>
		
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		
		<label>접종 받는 분 이름</label>
		<input type='text' name='myName' placeholder="홍길동"/>
		<hr/>
		
		<label>접종 받는 분 전화번호</label>
		<input type='text' id='myPhone' name='myPhone' placeholder="010-0000-0000"/>
		<hr/>
		
		<label>접종 받는 분 주민등록번호</label>
		<input type='text' name='myJumin' id='myJumin' placeholder="000000-0000000" maxlength="14"/>
		<hr/>
		
		<label>예약 백신</label>
			<select name='reserveVaccine' id='reserveVaccine'>
				<option value='얀센'>얀센</option>
				<option value='화이자'>화이자</option>
				<option value='모더나'>모더나</option>
				<option value='시노팜'>시노팜</option>
				<option value='아스트라제네카'>아스트라제네카</option>
			</select>
		<hr/>
		
		<label>정보 수신 이메일</label>
		<input type='text' name='Email' id='Email' placeholder="1234@1234.com"/>
		<hr/>
		
		<label>의료기관 및 예약일시 선택</label>
		<input type='button' id='' value='의료기관 찾기' onclick="button_a()"/>
		<br/>
		<label>예약 일시</label>
		<input type='text' name='reserveTime' id='reserveTime' readonly/>
		<br/>
		<label>예약 시간</label>
		<input type='text' name='reserveDate' id='reserveDate' readonly/>
		<br/>
		<label>예약 장소</label>
		<input type='text' name='reserveCenter' id='reserveCenter'  size="40" readonly/>
		<br/>
		<label></label>
		<input type='text' name='facilityName' id='facilityName'  size="40" readonly/>
		<input type='button' id='btnReserveOther' value='예약'/>
		<input type='button' value='취소' onclick="$('#middle').load('./doReserve.reserve');"/>
		<hr/>
		
		<input type='hidden' name='dong' id='dong'/>
		
	</form>
</div>
<script>
reserve.init();
reserve.otherkeyup();
function smsPopup() {
	window.open("./reserve/sms.jsp", "a", "width=850, height=300, left=100, top=50");
	}
function emailPopup() {
	window.open("./reserve/email.jsp", "b", "width=850, height=300, left=100, top=50");
	}
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCOLIebDhLkY-CHMWTNkDj3NLzWWJCsfv0&callback=initMap&region=kr">
</script>
</body>
</html>