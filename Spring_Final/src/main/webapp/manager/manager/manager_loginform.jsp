<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>관리자 로그인 페이지</title>
<style>
#login_wrapper{
	margin: 210px auto;
    width: 800px;
    height: 350px;
    border: 15px solid #606b79;
    border-radius: 15px;
    display: flex;
}
#login_wrapper>div:first-child{
	flex: 1;
}
#login_wrapper>div{
	flex: 1.5;
}
#login_id{
    margin-top: 130px;
    margin-bottom: 15px;
    margin-left: 75px;
    height: 30px;
    width: 250px;
    border: 2px solid #767676;
    border-radius: 5px;
    padding: 0px 5px;
}
#login_pwd{
	margin-left: 75px;
    height: 30px;
    width: 250px;
    border: 2px solid #767676;
    border-radius: 5px;
    padding: 0px 5px;
}
#img_wrapper{
	height: 130px;
    margin-top: 65px;
}
#text_wrapper{
    text-align: center;
    font-size: 28px;
    margin-top: 20px;
}
#login_img{
    position: relative;
    left: 100px;
    height: 100%;
}
#text_wrapper{
    text-align: center;
    font-size: 28px;
}
#login_btn{
	position: relative;
    left: 355px;
    width: 100px;
    height: 88px;
    top: -88px;
    background-color: #5c6f88;
    color: #ffffff;
    font-size: 20px;
    font-weight: bold;
}
#login_left{
    border-right: 3px outset;
    border-right-style: groove;
}
</style>
</head>
<body>
<div id="login_wrapper">
	<div id="login_left">
		<div id="img_wrapper">
			<img id="login_img" alt="암호사진" src="/Spring_Final/manager/manager/login.png">
		</div>
		<div id="text_wrapper">관리자 페이지입니다</div>
		<div></div>
	</div>
	<div id="login_right">
		<form id="login_frm" name="login_frm" method="post" action="">
			<input type="text" id="login_id" name="mid" placeholder="ID">   <br/>
			<input type="password" id="login_pwd" name="password" placeholder="PASSWORD"> <br/>
			<input type="button" id="login_btn" value="로그인" onclick="login()">
		</form>
	</div>
</div>

<script src='../js/manager.js'></script>
</body>
</html>