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
<title>예약 조회</title>
</head>
<style>
#reserve form>label{
	display:inline-block;
	width:200px;
}
#reserveMap	{
	margin: 15px;
    width: 482px;
    height: 300px;
    border: 1px solid black;
}
</style>
<body>
<h2>예약 결과가 조회 되었습니다.</h2>
<div id='reserve'>
	<form name='frm_reserve' id='frm_reserve' method='post' action=''>
		<div>
			<div>1단계 | 본인인증 및 예약여부 확인</div>
			<div>2단계 | 예약정보 조회</div>
		</div>
		<br/>
		
		<h3>예약자 정보</h3>
		<hr/>
		<label>예약자 이름</label>
		<input type='text' name='Name' value='${list2.otherName }' readonly/>
		<hr/>
		<label>예약자 주민등록번호</label>
		<input type='text' name='Jumin' value='${list2.otherJumin }' readonly/>
		<hr/>
		
		<h3>예약 정보</h3>
		<label>예약 번호</label>
		<input type='text' name='reserveNum' value='${list.reserveNum }' readonly/>
		<hr/>
		<label>접종 받는 분 이름</label>
		<input type='text' name='myName' value='${list.myName }' readonly/>
		<hr/>
		<label>접종 받는 분 주민등록번호</label>
		<input type='text' name='myJumin' value='${list.myJumin }' readonly/>
		<hr/>
		<label>예약 백신</label>
		<input type='text' name='reserveVaccine' value='${list.reserveVaccine }' readonly/>
		<hr/>
		<label>예약 의료기관</label>
		<input type='text' name='reserveCenter' id='reserveCenter' value='${list.reserveCenter }' size="40" readonly/>
		<br/>
		<label></label>
		<input type='text' name='facilityName' id='facilityName' value='${list.facilityName }' readonly/>
		<label></label>
		<div id='reserveMap'></div>
		<hr/>
		<label>접종일</label>
		<input type='text' name='reserveDate' value='${list.reserveDate }' readonly/>
		<hr/>
		<label>접종 시간</label>
		<input type='text' name='reserveTime' value='${list.reserveTime }' readonly/>
		<hr/>
		<input type='button' id='btnCancle' value='예약 취소'/>
		<input type='button' value='홈으로'/>
		<hr/>
	
	</form>
</div>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCOLIebDhLkY-CHMWTNkDj3NLzWWJCsfv0&callback=initMap&region=kr"></script>
<script>reserve.init();</script>
<script>

function initMap()	{
	
	var cn = document.getElementById('reserveCenter').value;
	var fn = document.getElementById('facilityName').value;
	
	var param = "centerName="+cn+"&facilityName="+fn;
	
	
	$.ajax({
		type: 'post',
		url : './mapChk.vCenter',
		data : param,
		success: function(resp){
			var a = resp.trim().split(',');

		 var center = {lat: Number(a[0]) ,lng: Number(a[1]) };       
		    var map = new google.maps.Map(document.getElementById('reserveMap'), {
		        zoom: 17,
			    center: center
		      });
		    
		    var marker = new google.maps.Marker({position: center, map: map});
		}
	})
}	
</script>
</body>
</html>