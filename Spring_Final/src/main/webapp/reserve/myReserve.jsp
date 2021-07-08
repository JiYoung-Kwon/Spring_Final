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
<title>본인 예약</title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:200px;
	padding-top: 5px;
}

h2 {
    font-size: 36px;
    color: #0068b7;
}

input[type=text]:focus::placeholder{
color: transparent;
}

#mybutton{
	width: 250px;
    height: 115px;
    border: 1px solid;
    border-radius: 5px;
    display: inline-block;
}
#a{
	height: 25px;
    font-size: 16px;
    color: #666;
    font-weight: bold;
    margin: 17px auto;
    margin-bottom: 0px;
    width: max-content;
}
#b{
	height: 50px;
    font-size: 35px;
    font-weight: bold;
    text-align: center;
}
#b1{
    margin-right: 15px;
    color: #2c89cf;
}
#b2{
	 color: #666;
}

#b3{
    margin-right: 15px;
    color: #f18c09;
}
 a:link { color: #000000; text-decoration: none;}
 a:visited { color: #000000; text-decoration: none;}
 a:hover { color: #22107b; text-decoration:none;}

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
<h2>본인 예약하기</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		
		<div>1단계 | 예약정보 입력</div>
		<div>2단계 | 예약완료 안내</div>
		<br/>
		
		<div class="box-use">
			<h3>개인정보 수집 및 이용에 대한 안내</h3>
			<p>「감염병의 예방 및 관리에 관한 법률」 제33조의 4 및 같은 법 시행령 제32조의 3에 따라 코로나19 예방접종 예약신청을 위하여 다음의 개인정보를 수집합니다.</p>
		</div>
		
		<hr/>
		
		<label>이름</label>
		<input type='text' name='myName' id='myName' placeholder="홍길동"/>
		<hr/>
		
		<label>주민등록번호</label>
		<input type='text' name='myJumin' id='myJumin' placeholder="000000-0000000" maxlength="14"/>
		<hr/>
		
		<label>본인인증</label>
		<a href="javascript:void(0);" onclick="smsPopup();">
		<div id="mybutton">
			<div id="a">코로나19 예방접종</div>
			<div id="b"><font id="b1">SMS</font><font id="b2">문자인증</font></div>
		</div>
		</a>
			
		<a href="javascript:void(0);" onclick="emailPopup();">
		<div id="mybutton">
				<div id="a">코로나19 예방접종</div>
				<div id="b"><font id="b3">E-mail</font><font id="b2">인증</font></div>
		</div>
		</a>
		<br/>
		<label></label>
		<input type='text' id='reserveOk' name='reserveOk' style="margin-top: 10px;" value='인증을 완료하여 주세요' readonly/>
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
		
		<label>휴대폰 번호</label>
		<input type='text' name='myPhone' id='reservePhone' style="margin-bottom: 5px;" placeholder="010-0000-0000" maxlength="13"/>
		<br/>
		<span>* 본인 명의의 휴대폰이 아닌경우 온라인 예약이 불가능합니다.</span>
		<hr/>
		
		<label>정보 수신 이메일</label>
		<input type='text' name='Email' id='Email' placeholder="1234@1234.com"/>
		<hr/>
		
		<label>의료기관 및 예약일시 선택</label>
		<input type='button' class='btn wide2 orange' value='의료기관 찾기' onclick="button_a()"/>
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
		<input type='button' id='btnReserve' class="btn blue wide" value='예약'/>
		<input type='button' value='취소' class="btn white homeBtn" onclick="$('#middle').load('./doReserve.reserve');"/>
		<hr/>

		<input type='hidden' name='dong' id='dong'/>

	</form>

</div>
<script>
reserve.init();
reserve.mykeyup();
function smsPopup() {
	var _width = '550';
    var _height = '250';
 
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/3); 
 
    window.open("./reserve/sms.jsp", 'sms', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
	}
function emailPopup() {
	var _width = '550';
    var _height = '250';
 
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/3); 
 
    window.open("./reserve/email.jsp", 'e-mail', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
	}
</script>	
</body>
</html>