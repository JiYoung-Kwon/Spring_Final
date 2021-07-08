<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>관리자 로그인 페이지</title>
<link rel='StyleSheet' type='text/css' href='../css/manager.css'>
<script src='../../notice/jquery/jquery.js'></script>
</head>
<body>
<div id='loginform'>
  
  <div id='login'>
    <label style='font-size:50pt;'>관리자 로그인</label>
    <br/><br/><br/>
    
    <form id='login_frm' name='login_frm' method='post' action=''>
   	  <label>아이디</label>
      <input id='login_id' name='login_id' type='text'/>
      <label>비밀번호</label>
      <input id='login_pwd' name='login_pwd' type='password'/>
    </form>
    <br/>
    
    <div id='btn_zone'>
      <input id='login_btn' type='button' value='로그인'/>
    </div>
  </div>
</div>

<script src='../js/manager.js'></script>
</body>
</html>