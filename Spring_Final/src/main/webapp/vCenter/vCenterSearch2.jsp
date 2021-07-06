<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<div id="center_n">${vo.centerName }</div>
	<div id="infomation">
		<div id="facility">
			<div>시설 이름</div>
			<div id="center_f">${vo.facilityName }</div>
		</div>
		<div id="phone">
			<div>연락처</div>
			<div id="center_p">${vo.phoneNumber }</div>
		</div>
		<div id="address">
			<div>주소</div>
			<div id="center_a">${vo.address }</div>
		</div>
	</div>
	<div id="rt">
		<div>시간선택</div>	
		<div>
			<input type="radio" class="time_hidden" name="time" value="09:00" id="t1">
			<label for="t1" class="tl">09:00</label>
			<input type="hidden" class="timeChk" value="${list[0]}"/>
			<input type="radio" class="time_hidden" name="time" value="10:00" id="t2">
			<label for="t2" class="tl">10:00</label>
			<input type="hidden" class="timeChk" value="${list[1]}"/>
			<input type="radio" class="time_hidden" name="time" value="11:00" id="t3">
			<label for="t3" class="tl">11:00</label>
			<input type="hidden" class="timeChk" value="${list[2]}"/>
			<input type="radio" class="time_hidden" name="time" value="12:00" id="t4">
			<label for="t4" class="tl">12:00</label>
			<input type="hidden" class="timeChk" value="${list[3]}"/>
			<input type="radio" class="time_hidden" name="time" value="13:00" id="t5">
			<label for="t5" class="tl">13:00</label>
			<input type="hidden" class="timeChk" value="${list[4]}"/>
			<br/>
			<input type="radio" class="time_hidden" name="time" value="14:00" id="t6">
			<label for="t6" class="tl">14:00</label>
			<input type="hidden" class="timeChk" value="${list[5]}"/>
			<input type="radio" class="time_hidden" name="time" value="15:00" id="t7">
			<label for="t7" class="tl">15:00</label>
			<input type="hidden" class="timeChk" value="${list[6]}"/>
			<input type="radio" class="time_hidden" name="time" value="16:00" id="t8">
			<label for="t8" class="tl">16:00</label>
			<input type="hidden" class="timeChk" value="${list[7]}"/>
			<input type="radio" class="time_hidden" name="time" value="17:00" id="t9">
			<label for="t9" class="tl">17:00</label>
			<input type="hidden" class="timeChk" value="${list[8]}"/>
		</div>	
	</div>
<input type="hidden" id="lat" value="${vo.lat }"/>
<input type="hidden" id="lng" value="${vo.lng }"/>

<script type="text/javascript" src="../reservejs/vCenter.js"></script>
<script type="text/javascript">load()</script>
<script type="text/javascript">infor_init()</script>
</body>
</html>