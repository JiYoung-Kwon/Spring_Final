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
h3 {
    font-size: 36px;
    color: #0068b7;
}
#reserve #btnMyReserve, #btnOtherReserve{
 width:300px;height:200px;font-size:20px;
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

</style>
<body>
<h2>예약하기</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<h3>예약 종류를 선택하여 주세요</h3>
		<span>코로나 19 예방접종의 경우 본인 예약과 대리 예약을 할 수 있습니다. 원하시는 방법을 선택하여 주세요.</span>
		<hr/>
		<div id="doBtn">
		<a href="javascript:void(0);" onclick="$('#middle').load('./my.reserve');">
			<div id="mybutton">
				<div id="a">코로나19 예방접종</div>
				<div id="b"><font id="b1">본인</font><font id="b2">예약</font></div>
			</div>
		</a>
		
		<a href="javascript:void(0);" onclick="$('#middle').load('./other.reserve');">
			<div id="mybutton">
				<div id="a">코로나19 예방접종</div>
				<div id="b"><font id="b3">대리</font><font id="b2">예약</font></div>
			</div>
		</a>
		</div>
		<hr/>
		<div id='spantext' style="padding-bottom: 10px;">
		<span>대리 예약의 경우에도 본인 인증 수단이 필요합니다. 대리 예약 하여 주시는 분의 휴대폰 또는 E-mail을 준비하여 주세요.</span>
		</div>
	</form>

</div>
<script>reserve.init();</script>
</body>
</html>