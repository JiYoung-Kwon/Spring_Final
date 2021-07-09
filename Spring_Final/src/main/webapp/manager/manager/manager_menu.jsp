<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>관리자 메뉴</title>
<script src='/Spring_Final/notice/jquery/jquery.js'></script>
<script src='../js/manager.js'></script>
</head>
<link rel='StyleSheet' type='text/css' href='../css/manager.css'>
<body>
	<div id='manager_menu'>
		<h1>관리자 페이지</h1>
		<div id='manager_ui'>
			<img src="../img/manager.jpg" id='manager_image'><br /> <label>관리자
				님</label>
			<!-- 관리자 아이디명이 들어갈 곳 -->
		</div>

		<div id='menu_bar'>
			<ul>
				<li id='btnmanager'>관리자 계정 관리</li>
				<li>게시판 관리
					<ul class='sub'>
						<li onclick="MNoticeGoPage()">공지사항</li>
						<li>생활속방역수칙</li>
						<li class="News" id="NI" onclick="$('#frm_manager').load('../../NI/search.brd?tabGubun=issue_M');" data-ajax = "false">>뉴스&이슈</li>
					</ul></li>
				<li>메인 홈페이지 관리
				<li>예약 관리</li>
			</ul>
		</div>
	</div>
</body>
</html>