<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script src="./jquery/jquery.js"></script>

</head>
<body>
	<div id="notice">
		<form id="main" name="main" method="post" action="">
			<input id="button1" name="button1" type="button" value="유 저 공지사항" onclick="main1()">
			<input id="button2" name="button2" type="button" value="관리자 공지사항" onclick="main2()">
		</form>
	</div>
	
	<script src="./notice.js"></script>
</body>
</html>