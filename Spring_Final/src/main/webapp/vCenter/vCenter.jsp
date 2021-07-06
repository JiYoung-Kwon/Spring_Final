<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#center_wrapper{
    width: 500px;
    height: max-content;
	border: 1px solid black;
}

#frm_center{
    margin: 0 auto;
    width: 450px;
}

#frm_center>label{
	width: 75px;
    display: inline-block;
    margin: 10px 0 10px 0;
}
#frm_center>label:first-child{
	width: 81px;
    display: inline-block;
}

#frm_center>select{
    display: inline-block;
    height: 25px;
}
#sido{
    width: 120px;
}
#sigungu{
    width: 140px;
}
#dong{
    width: 97px;
}

#frm_center>input[type=date]{
	width: 363px;
}
#frm_center>input[type=button]{
 	width: 450px;
    margin: 10px 0 10px 0;
}    
#center_div{
	height: 350px;
	border: 1px solid black;
    width: 450px;
    margin: 0 auto;
    display: flex;
    word-break: keep-all;
}    
#center_div>#center_name{
	flex:1;
	overflow: auto;
}
#center_div>#center_name>.center{
	width: 150px;
    height: 90px;
    border: 1px solid black;
    border-radius: 10px;
    margin: 5px auto;
    cursor: pointer;
    overflow: hidden;
}
#center_div>#center_name>.center:hover{
	background: #f1f1f1;
}
#center_div>#center_name>.center>div{
    font-size: 13.5px;
    margin: 2px;
    text-align: center;
}
#center_div>#center_name>.center>div:first-child{
    font-size: 15.5px;
    margin: 5px;
    font-weight: bold;
}
#center_div>#center_information{
 	border-left: 1px solid black;
 	flex:1.5;
}
#center_div>#center_information>#center_n{
    font-size: 77%;
    width: max-content;
    margin: 10px auto;
    font-weight: bold;
    background: #efefef;
    min-width: 200px;
}
#center_div>#center_information>#infomation{
	height: 175px;
	padding: 5px;
}
#infomation>div{
	height: 25%;
	box-sizing: border-box;
	display: flex;
}
#infomation>div>div:first-child{
    flex: 1.5;
    font-size: 13px;
    font-weight: bolder;
   	height: 18px;
   	display: inline;
   	margin: auto;
   	text-align: center;
    border-right: solid;
    background: #efefef;
}
#infomation>div>div:last-child{
    flex: 4;
    font-size: 13px;
    height: 20px;
    display: inline;
    margin: auto;
    padding-left: 5px;
}
#infomation>#address{
	display: block;
	height: max-content;
	
}
#infomation>#address>div:first-child{
	height: 30px;	
	display: block;
	line-height: 2;
    background: #efefef;
    border-right: 0;
}
#infomation>#address>div:last-child{
    height: 67px;
    display: block;
    font-size: 15px;
    text-align: center;
    padding-left: 0px;
    margin-top: 10px;
}
#center_map{
	width: 450px;
    height: 265px;
    border: 1px solid black;
    border-top: 0px;
    margin: 0 auto;
}    
#center_select{
    display: block;
    width: 450px;
    margin: 10px auto;
}
#rt{
	width:100%;
	height:115px;
}

#rt>div:first-child{
    background: #efefef;
    height: 30px;
    text-align: center;
    font-size: 13px;
	font-weight: bold;
    line-height: 2;
}
#rt>div:last-child{
	width: max-content;
    margin: auto;
    line-height: 2.5;
}
.time_hidden{
	display: none;
}
.time_over_people{
	pointer-events:none;
	background-color: #cec1c1c7;
	color: #ffffff;
	display: inline-block;
    width: 40px;
    height: 25px;
    margin: 3px;
    text-align: center;
    line-height: 1.8;
    font-size: 13px;
    font-weight: bold;
}
.tl{
    background: #9a9090;
    color:#ffffff;
    cursor: pointer;
    display: inline-block;
	width: 40px;
    height: 25px;
    margin: 3px;
    text-align: center;
    line-height: 1.8;
    font-size: 13px;
    font-weight: bold;
}
.time_hidden:checked +.tl {
    background: #1d1d1d;
    color: #ffffff;
}
.gm-style-mtc{
	display: none;
}
</style>

</head>

<body>
<div id="center_wrapper">
	<form id="frm_center">
		<label>예약일</label><input type="date" id='date'><br>
		<label>지역선택</label>
		<select name="sido" id="sido">
			<option value="none">시/도</option>
		</select>
		<select  name="sigungu" id="sigungu">
			<option value="none">시/군/구</option>
		</select>
		<select name="dong" id="dong">
			<option value="none">읍/면동/리</option>
		</select>
		<br/>
		<input type="button" value="의료기관 검색" id="btn_center_search">
	</form>
	<div id="center_div">
<div id="center_name">
</div>
<div id=center_information>
	<div id="center_n">&nbsp</div>
	<div id="infomation">
		<div id="facility">
			<div>시설 이름</div>
			<div id="center_f"></div>
		</div>
		<div id="phone">
			<div>연락처</div>
			<div id="center_p"></div>
		</div>
		<div id="address">
			<div>주소</div>
			<div id="center_a"></div>
		</div>
	</div>
	<div id="rt">
		<div>시간선택</div>	
		<div>
			<input type="radio" class="time_hidden" name="time" value="09:00" id="t1">
			<label for="t1" class="tl">09:00</label>
			<input type="radio" class="time_hidden" name="time" value="10:00" id="t2">
			<label for="t2" class="tl">10:00</label>
			<input type="radio" class="time_hidden" name="time" value="11:00" id="t3">
			<label for="t3" class="tl">11:00</label>
			<input type="radio" class="time_hidden" name="time" value="12:00" id="t4">
			<label for="t4" class="tl">12:00</label>
			<input type="radio" class="time_hidden" name="time" value="13:00" id="t5">
			<label for="t5" class="tl">13:00</label>
			<br/>
			<input type="radio" class="time_hidden" name="time" value="14:00" id="t6">
			<label for="t6" class="tl">14:00</label>
			<input type="radio" class="time_hidden" name="time" value="15:00" id="t7">
			<label for="t7" class="tl">15:00</label>
			<input type="radio" class="time_hidden" name="time" value="16:00" id="t8">
			<label for="t8" class="tl">16:00</label>
			<input type="radio" class="time_hidden" name="time" value="17:00" id="t9">
			<label for="t9" class="tl">17:00</label>
		</div>	
	</div>
</div>
	</div>
	<div id="center_map"></div>
	
	
	<input type="button" value="예약선택" id="center_select">
</div>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCOLIebDhLkY-CHMWTNkDj3NLzWWJCsfv0&callback=initMap&region=kr"></script>
<script type="text/javascript" src="../reservejs/vCenter.js">initMap()</script>
<script type="text/javascript">load()</script>
<script type="text/javascript">time()</script>
</body>
</html>