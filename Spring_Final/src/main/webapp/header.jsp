<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>header</title>

</head>
<body>
	<div id="header">
		<div id="header_logo">
			<div id="logo_IF">
				<div id="icon">
					<img alt="손바닥이미지" src="./img/son.png">
				</div>
				<div id="font">
					코로나! 멈춰!
				</div>
			</div>
		</div>
		<div id="header_menu">
			<ul id="menu_wrapper">
				<li class="main_menu">   <!-- 메뉴 탭 -->
					<a>코로나발생동향</a>         
						<ul id="sub1" class="sub_wraaper">  <!-- 서브 메뉴 -->
							<li class="sub_menu" onclick= "$('#middle').load('/Spring_Final/corona/searchK.corona');" data-ajax = "false">
							<a>국내 발생 현황</a>
							</li>
							<li class="sub_menu" onclick= "$('#middle').load('/Spring_Final/corona/searchG.corona');" data-ajax = "false">
							<a>국외 발생 현황</a>
							</li>
							<li class="sub_menu">
							<a>시도별 발생 현황</a>
							</li>
							<li class="sub_menu">
							<a>메뉴4</a>
							</li>
						</ul>
				</li>                       <!-- 메뉴 끝  -->
				<li class="main_menu">   <!-- 메뉴 탭 -->
					<a>백신접종현황</a>         
						<ul id="sub2" class="sub_wraaper">  <!-- 서브 메뉴 -->
							<li class="sub_menu">
							<a>국내 접종 현황</a>
							</li>
							<li class="sub_menu">
							<a>국외 접종 현황</a>
							</li>
							<li class="sub_menu">
							<a>메뉴3</a>
							</li>
							<li class="sub_menu">
							<a>메뉴4</a>
							</li>
						</ul>
				</li>                       <!-- 메뉴 끝  -->
				<li class="main_menu">   <!-- 메뉴 탭 -->
					<a>백신예약</a>         
						<ul id="sub3" class="sub_wraaper">  <!-- 서브 메뉴 -->
							<li class="sub_menu">
							<a>예약하기</a>
							</li>
							<li class="sub_menu">
							<a>조회하기</a>
							</li>
							<li class="sub_menu">
							<a>메뉴3</a>
							</li>
							<li class="sub_menu">
							<a>메뉴4</a>
							</li>
						</ul>
				</li>                       <!-- 메뉴 끝  -->
				<li class="main_menu">   <!-- 메뉴 탭 -->
					<a>뉴스&이슈</a>         
						<ul id="sub4" class="sub_wraaper">  <!-- 서브 메뉴 -->
							<li class="sub_menu">
							<a>뉴스게시판</a>
							</li>
							<li class="sub_menu">
							<a>이슈게시판</a>
							</li>
							<li class="sub_menu">
							<a>이시국 취미생활</a>
							</li>
						</ul>
				</li>                       <!-- 메뉴 끝  -->

				<li class="main_menu">   <!-- 메뉴 탭 -->
					<a>의료기관찾기</a>         
						<ul id="sub5" class="sub_wraaper">  <!-- 서브 메뉴 -->
							<li class="sub_menu">
							<a>국민안심병원</a>
							</li>
							<li class="sub_menu">
							<a>코로나검사 실시기관</a>
							</li>
							<li class="sub_menu">
							<a>코로나 선별진료소 운영기관</a>
							</li>
							<li class="sub_menu">
							<a>메뉴4</a>
							</li>
						</ul>
				</li>                       <!-- 메뉴 끝  -->
			</ul>
		</div>
	</div>
</body>
</html>