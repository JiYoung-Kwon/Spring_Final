<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>관리자 메인페이지</title>
<script src='../js/manager.js'></script>
</head>
<link rel='StyleSheet' type='text/css' href='../css/manager.css'>
<body>
	<%
	String menu = "../manager/manager_menu.jsp";  
	%>
	<div id='managerhome'>
		<div id='menu'>
			<jsp:include page="<%=menu %>" />
		</div>

		<form id='frm_manager' name='frm_manager' method='POST' action=''>
		<input type="hidden" id="login_id" value=<%=session.getAttribute("login") %>>
		</form>
	</div>
<script type="text/javascript">init();</script>
</body>
</html>