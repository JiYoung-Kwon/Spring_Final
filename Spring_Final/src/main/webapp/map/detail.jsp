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
		<dd>π¨ββοΈ μμΈ κ°λ¨κ΅¬  μ­μΌλ 786-24(λκ³‘λ‘229)${vo.address } </dd>
		<dd>π ${vo.phoneNumber } </dd>
	</dl>
</div>		
</body>
</html>