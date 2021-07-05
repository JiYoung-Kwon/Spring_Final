<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<meta charset="UTF-8">
<title>index</title>
<link href="./main.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
 	<div id="header"><jsp:include page="./header.jsp"></jsp:include></div>
	<div id="middle"><jsp:include page="./mainPage.jsp"></jsp:include></div> <!-- 여기 div에 load 시키세요! -->
	<div id="footer"><jsp:include page="./footer.jsp"></jsp:include></div>
</div>
<script type="text/javascript" src="./main.js"></script>
</body>
</html>