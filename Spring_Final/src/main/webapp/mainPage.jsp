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
					<div class="content_title">코로나19 예방접종<br/><font class="font_point">온라인</font><font class="font_color">예약방법</font></div>
					<div class="content_sub">
						<div class="name">누구나 편리하게<br/>이용할 수 있도록</div>
						<div class="button">
							<input type="button" value="자세히">
						</div>
					</div>
				</div>
				<div id="content2" class="content">
					<div class="content_title">코로나19 예방접종<br/><font class="font_color">콜센터</font><font class="font_point">안내</font></div>
					<div class="content_sub">
						<div class="name">취약계층을 위한<br/>콜센터 운영</div>
						<div class="button">
							<input type="button" value="자세히">
						</div>
					</div>
				</div>
				<div id="content3" class="content">
					<div class="content_title">사업참여<br/><font class="font_color">의료기관</font><font class="font_point">찾기</font></div>
					<div class="content_sub">
						<div class="name">코로나19 예방접종사업<br/>참여의료기관 정보</div>
						<div class="button">
							<input type="button" value="자세히">
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
			
			
			<!-- <div id="link2" class="bottom_link">
				<a target="_blank" href=" https://youtu.be/APOt56usrt4">
					<img alt="코로나 link 이미지1" src="http://ncov.mohw.go.kr/upload/ncov/20210331144816.jpg">
				</a>
			</div>
			<div id="link3" class="bottom_link">
				<a target="_blank" href=" https://youtu.be/hlcrgEeF9nQ">
					<img alt="코로나 link 이미지2" src="http://ncov.mohw.go.kr/upload/ncov/20210305171415.jpg">
				</a>
			</div>
			<div id="link4" class="bottom_link">
				<a target="_blank" href=" https://youtu.be/z4V-svP6yY8">
					<img alt="코로나 link 이미지3" src="http://ncov.mohw.go.kr/upload/ncov/20210115160226.jpg">
				</a>
			</div> -->
			
			
		</div>
</body>
</html>