<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>middle_mainPage</title>
</head>
<body>
	   <div id="top_banner">
			<div id="top_banner_content">
				<img id="banner_img" alt="배너이미지" src="./img/banner1.png" onclick="banner()"> <!-- 배너 이미지  -->
				<input id="btn_left" class="banner_button" type="button"/>	
				<input id="btn_right" class="banner_button" type="button"/>
				<input id="btn_num" class="banner_num" type="hidden" value='1'/>
				
			</div>
		</div>
		<div id="corona">		<!-- 지영씨 메인 페이지 load 할곳  -->
			
			<div id="table">
				<div id="table_content">
					<img alt="테이블이미지" src="./table.png">
				</div>
			</div>
			
			<script>$('#corona').load('/Spring_Final/corona/searchC.corona')</script>
			
			<%-- <jsp:include page="corona/searchC.corona"></jsp:include> --%>
		</div>
		<div id="bottom_banner"> <!--  하단 배너  -->
			<div id="banner_content">
				<div id="content1" class="content">  
					<div class="content_title">코로나19 예방접종<br/><font class="font_point">온라인</font><font class="font_color">예약</font></div>
					<div class="content_sub">
						<div class="name">백신 예약을 <br/>하고싶으신가요?</div>
						<div class="button">
							<input type="button" value="자세히" onclick="$('#middle').load('./doReserve.reserve');">
						</div>
					</div>
				</div>
				<div id="content2" class="content">
					<div class="content_title">코로나19 관련<br/><font class="font_color">의료기관</font><font class="font_point">찾기</font></div>
					<div class="content_sub">
						<div class="name">코로나19 관련<br/>의료기관이 궁금하다면?</div>
						<div class="button">
							<input type="button" value="자세히" onclick="$('#middle').load('./map.hospital?gubun=0')">
						</div>
					</div>
				</div>
				<div id="content3" class="content">
					<div class="content_title">코로나19<br/><font class="font_color">예방접종</font><font class="font_point">현황</font></div>
					<div class="content_sub">
						<div class="name">코로나19 예방접종<br/>현황을 알고 싶다면?</div>
						<div class="button">
							<input type="button" value="자세히" onclick="$('#middle').load('/Spring_Final/graph/ko.graph')">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div>
		
			
		</div>
		<div id="bottom_link">
			<div id="link1" class="bottom_link">
				#지금 우리는<br/>
				#힘내라 대한민국<br/>
				#우리는 할 수 있습니다<br/>
				#코로나19 물렀거라!
			</div>
			
			<div id="link2" class="bottom_link">
				<jsp:include page="/youtube.do"></jsp:include>
			</div>			
		</div>
</body>
</html>