<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>detail</title>
<link rel='stylesheet' type='text/css' href='../css/map.css'>
</head>
<body>
<div id='detail'>
	<dl id='notice'>
		<dt>${vo.hospitalName } </dt>
		<dd>👨‍⚕️ 서울 강남구  역삼동 786-24(도곡로229)${vo.address } </dd>
		<dd>📞 ${vo.phoneNumber } </dd>
	</dl>
</div>		
</body>
</html>