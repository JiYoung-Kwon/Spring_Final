<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='/Spring_Final/reservejs/reserve.js'></script>
<meta charset="UTF-8">
<title>header</title>
<style>
#i_img {
	transform: translate(1350px, -15px);
}

.i_img {
	width: 30px;
	margin: 25px 12px 0 0;
	cursor: pointer;
}
</style>
</head>
<body>
	<div id="header">
		<div id="header_logo">
			<div id="logo_IF">
				<div id="font">ππ» μ½λ‘λ! λ©μΆ°!</div>
			</div>
			
			<div id="i_img">
                <a href="https://youtube.com/channel/UCa7-3Zvxg-5Rfxgu3RQY_gw"><img src="img/png1.png" alt="" class="i_img"></a>
                <a href="http://www.facebook.com/koreadca"><img src="img/png2.png" alt="" class="i_img"></a>
                <a href="https://www.instagram.com/k__doooong"><img src="img/png3.png" alt="" class="i_img"></a>
                <a href="https://github.com/JiYoung-Kwon/Spring_Final"><img src="img/png4.png" alt="" class="i_img" id="img_i"></a>
            </div>
		</div>
		<div id="header_menu">
			<ul id="menu_wrapper">
				<li class="main_menu">
					<!-- λ©λ΄ ν­ --> <a >μ½λ‘λλ°μλν₯</a>
					<ul id="sub1" class="sub_wraaper">
						<!-- μλΈ λ©λ΄ -->
						<li class="sub_menu"
							onclick="$('#middle').load('/Spring_Final/corona/searchK.corona');"
							data-ajax="false"><a>κ΅­λ΄ λ°μ νν©</a></li>
						<li class="sub_menu"
							onclick="$('#middle').load('/Spring_Final/corona/searchG.corona');"
							data-ajax="false"><a>κ΅­μΈ λ°μ νν©</a></li>
					</ul>
				</li>
				<!-- λ©λ΄ λ  -->
				<li class="main_menu">
					<!-- λ©λ΄ ν­ --> <a>λ°±μ μ μ’νν©</a>
					<ul id="sub2" class="sub_wraaper">
						<!-- μλΈ λ©λ΄ -->
						<li class="sub_menu" onclick="$('#middle').load('/Spring_Final/graph/ko.graph');"><a>κ΅­λ΄ μ μ’ νν©</a></li>
						<li class="sub_menu" onclick="$('#middle').load('/Spring_Final/graph/G7.graph');"><a>κ΅­μΈ μ μ’ νν©</a></li>
					</ul>
				</li>
				<!-- λ©λ΄ λ  -->
				<li class="main_menu">
					<!-- λ©λ΄ ν­ --> <a>λ°±μ μμ½</a>
					<ul id="sub3" class="sub_wraaper">
						<!-- μλΈ λ©λ΄ -->
						<li class="sub_menu"><a
							onclick="$('#middle').load('./doReserve.reserve');">μμ½νκΈ°</a></li>
						<li class="sub_menu"><a
							onclick="$('#middle').load('./sc.reserve');">μ‘°ννκΈ°</a></li>
					</ul>
				</li>
				<!-- λ©λ΄ λ  -->
				<li class="main_menu">
					<!-- λ©λ΄ ν­ --> <a>λ΄μ€&μ΄μ</a>
					<ul id="sub4" class="sub_wraaper">
						<!-- μλΈ λ©λ΄ -->
						<li class="sub_menu" id='Issue'
							onclick="$('#middle').load('NI/search.brd?tabGubun=issue');"
							data-ajax="false"><a>μνμ§μ­ μ΄μ</a></li>
						<li class="sub_menu" id="News"
							onclick="$('#middle').load('NI/search.brd?tabGubun=news');"
							data-ajax="false"><a>μ½λ‘λ κ΄λ ¨λ³΄λ</a></li>
						<li class="sub_menu" id="hobby"
							onclick="$('#middle').load('NI/search.brd?tabGubun=hobby');"
							data-ajax="false"><a id="hobby">μ΄μκ΅­ μ·¨λ―Έμν</a></li>
					</ul>
				</li>
				<!-- λ©λ΄ λ  -->

				<li class="main_menu">
					<!-- λ©λ΄ ν­ --> <a onclick="$('#middle').load('./map.hospital?gubun=0')">μλ£κΈ°κ΄μ°ΎκΈ°</a>
					<ul id="sub5" class="sub_wraaper">
						<!-- μλΈ λ©λ΄ -->
						<li class="sub_menu"><a id='hospital'
							onclick="$('#middle').load('./map.hospital?gubun=0')">κ΅­λ―Όμμ¬λ³μ</a>
						</li>
						<li class="sub_menu"><a id='careCenter'
							onclick="$('#middle').load('./map.hospital?gubun=1')">μ½λ‘λ
								μ λ³μ§λ£μ μ΄μκΈ°κ΄</a></li>
						<li class="sub_menu"><a id='testAgency'
							onclick="$('#middle').load('./map.hospital?gubun=2')">μ½λ‘λκ²μ¬
								μ€μκΈ°κ΄</a></li>
					</ul>
				</li>
				<!-- λ©λ΄ λ  -->

				<li class="main_menu" id="notice" onclick="unoticePageGo()">
					<!-- λ©λ΄ ν­ --> <a>κ³΅μ§μ¬ν­</a>
				</li>

				<li class="main_menu"
					onclick="$('#middle').load('./sanghwal/search.sanghwal');">
					<!-- λ©λ΄ ν­ --> <a>μνμ λ°©μ­μμΉ</a>
				</li>
				<!-- λ©λ΄ λ  -->
			</ul>
		</div>
	</div>
</body>
</html>