<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>footer</title>
</head>
<body>
	<div id="footer">
		<div id="footer_top">
			<span><a href="https://kosis.kr/covid/covid_cityStatus.do" onclick="window.open(this.href, '_blank' ,'width = 1000, height=500, scrollbars=yes'); return false;" class="go">시도별 발생현황 <!-- <img class="footer_icon" alt="바로가기아이콘" src="./img/footer_icon2.png"> --></a></span>
			<span><a href="https://kosis.kr/covid/covid_epidemicStatis.do" onclick="window.open(this.href, '_blank' ,'width = 1500, height=900, scrollbars=yes'); return false;"  class="go">감염병통계 <!-- <img class="footer_icon" alt="바로가기아이콘" src="./img/footer_icon2.png"> --></a></span>
			<span><a href="https://kosis.kr/covid/covid_hospitalInfo.do" onclick="window.open(this.href, '_blank','width = 1500, height=900, scrollbars=yes'); return false;"  class="go">코로나19 병원정보 <!-- <img class="footer_icon" alt="바로가기아이콘" src="./img/footer_icon2.png"> --></a></span>
		</div>
		<div id="footer_bottom">
			<div id="bottom_left">
				<div class="bottom_icon">
					<div class="content_icon"><a href="http://www.mohw.go.kr/"><img class="footer_icon2" alt="정부 아이콘" src="./img/footer_icon.png"></a></div>
					<div class="content_name">중앙사고수습본부</div>
				</div>
				<div class="bottom_icon">
					<div class="content_icon"><a href="http://www.kdca.go.kr/"><img class="footer_icon2" alt="정부 아이콘" src="./img/footer_icon.png"></a></div>
					<div class="content_name">중앙방역대책본부</div>
				</div>
				<div class="bottom_icon">  
					<div class="content_icon"><a href="http://www.mohw.go.kr/"><img class="footer_icon2" alt="정부 아이콘" src="./img/footer_icon.png"></a></div>
					<div class="content_name">보건복지부</div>
				</div>
			</div>
			<div id="bottom_right">
				<span>신고상담 ㅣ 보건소 <br> 질병관리청 콜센터 1339 ㅣ 지역번호 +120 ㅣ 지역번호 +114</span>
			</div>
		</div>
	</div>
</body>
</html>