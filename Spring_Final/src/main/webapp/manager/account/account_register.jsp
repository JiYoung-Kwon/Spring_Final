<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#account_reader_wrapper{
	width: 1100px;
	height: max-content;
}
#frm_wrapper{
	margin : 0 auto;
	width: 800px;
	height: max-content;
}
#account_header_frm{
    margin: 25px 0;
    font-weight: bold;
    font-size: 30px;
}
#account_board_frm{
	width: 800px;
    height: 460px;
	text-align: center;
	font-size: 20px;
    line-height: 2;
    background-color: #f7f7f7;
}
#account_board_frm label{
    width: 450px;
    display: inline-block;
    text-align: left;
    margin: 10px;
    margin-left: 180px;
}
#account_board_frm label:first-child{
	margin-top: 40px;
    margin-left: 140px;
	width: 337px;
}
#account_board_frm span{
    width: 130px;
    display: inline-block;
    text-align: right;
}
#account_board_frm input[type=text]{
    margin: 0 15px;
    height: 20px;
}
#account_board_frm img{
    position: relative;
    left: -64px;
    top: -365px;
}
.btn_account{
	float: right;
    margin: 20px 6px;
    margin-top: 15px;
    position: relative;
    width: 100px;
    height: 35px;
    top: 0px;
    left: -20px;
    font-size: 15px;
    font-weight: 700;
    border: 1px solid #d2d2d2;
}
#unotice_footer_frm{
	display:flex;
    margin: 50px auto;
    width: max-content;
}
#unotice_footer_frm input[type=button]{
    width: 40px;
    height: 40px;
}
#unotice_center{
	min-width: 273px;
}
#unotice_center input[type=button]{
	margin: 0 5px;
}
#pwdChk{
	width: 180px;
    height: 25px;
    position: relative;
    top: -340px;
    left: 290px;
    font-size: 12px;
    text-align: left;
    display: inline-block;
}
#idChk_btn{
	border: 1px solid #d2d2d2;
    width: 70px;
    height: 25px;
    font-size: 12px;
    font-weight: 500;
}
</style>
</head>
<body>
	<div id="account_reader_wrapper">
		
		
	<div id= "frm_wrapper">
		<div id="account_header_frm">관리자 계정 생성</div>
		<form id="account_board_frm" name="account_board_frm" method="post" action="">
			<label><span>ID</span><input type="text" id="mid" name="mid" placeholder="아이디" value="${vo.mid}"></label> <input id="idChk_btn" type="button" value="중복체크" onclick="idChk()"><br/>
			<input type="hidden" id="id_chk" name="id_chk" value="1";>
			<label><span>이름</span><input type="text" name="mname" placeholder="이름" value="${vo.mname}"></label> <br/>
 			<label><span>비밀번호</span><input type="text" id="pwd"  name="password" placeholder="비밀번호" onkeyup="passwordChk()"></label> <br/>
			<label><span>비밀번호 확인</span><input type="text" id="pwd2"  placeholder="비밀번호 확인" onkeyup="passwordChk()"></label> <br/>
			<label><span>업무명</span><input type="text" name="mjob" placeholder="업무명" value="${vo.mjob}"></label> <br/>
			<label><span>직책</span><input type="text" name="mposition" placeholder="직책" value="${vo.mposition}"></label> <br/>
			<img src="/Spring_Final/manager/account/icon.png">
			<div id="pwdChk"></div>
			
		<input id="nowPage" name="nowPage" type="hidden" value="${(empty page.nowPage) ? 1 : page.nowPage}">
		
		<input id="btn_return" class="btn_account" type="button" value="목록" onclick="accountReturn()"> 
		<input id="btn_register" class="btn_account" type="button" value="계정 생성" onclick="accountInsert()"> 

		</form>

		</div>
	</div>

	</div>
	<input type="hidden" id="login_id" value=<%=session.getAttribute("login") %>>
	<script type="text/javascript" src="../account/account.js">init()</script>
</body>
</html>