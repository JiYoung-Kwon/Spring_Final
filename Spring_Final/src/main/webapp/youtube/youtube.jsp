<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>mainPage</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id ='youtube'>
	<!-- <h2>유튜브 영상</h2> -->
<!--<a href = "corona/searchK.corona">국내 현황 조회</a>
	<a href = "corona/searchG.corona">국외 현황 조회</a>
	<a href = "corona/searchC.corona">시도별 현황 조회</a> -->
	
	<br/>
	<div id="player0"></div>
	<div id="player1"></div>
	<div id="player2"></div>
	
	<script src="/Spring_Final/youtubeJs/youtube.js"></script>
	<script>getJson(${yJson});</script>
</div>
</body>
</html>