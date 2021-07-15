<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta charset="UTF-8">
<title></title>
<style type="text/css">

#frm_pwd{
    width: max-content;
    height: max-content;
    display: inline-block;
}
#pwdChk{
	width: 131px;
    height: 17px;
    display: inline-block;
    position: relative;
    top: -21px;
    left: 307px;
    font-size: 12px;
}
#frm_pwd>label{
    width: 120px;
    display: inline-block;
}
#btn_zone{
    width: max-content;
    margin: 0 auto;
}
#frm_pwd #btn_zone>input[type=button]{
	width: 75px;
}
#frm_pwd #btn_zone>input[type=button]:first-child{
	margin-left: 250px;
}

</style>
</head>
<body>
	<form action="" id="frm_pwd">
		<label>현재비밀번호</label><input type="text" name="password" id="pwd"> <br/>
		<label>새비밀번호</label><input type="text" name="newPwd" id="new_pwd" onkeyup="pwdChk()"> <br/>
		<label>비밀번호확인</label><input type="text" id="new_pwd2" onkeyup="pwdChk()"> <br/>
		<input type="hidden" name="mid" id="mid">
		<input type="hidden" name="nowPage" id="nowPage">
		<input type="hidden" name="findStr" id="findStr">
		<div id="pwdChk"></div>
		<div id="btn_zone">
			<input type="button" value="변경하기" onclick="pwdChange()">
			<input type="button" value="취소" onclick=self.close()>
		</div>
	</form>
	
	
<script type="text/javascript">
//비밀번호 불일치 문구

function pwdChk(){
	var pwd = document.getElementById('new_pwd').value;
	var pwd2 = document.getElementById('new_pwd2').value;
	var div = document.getElementById('pwdChk') 

	if(pwd!=pwd2){
		div.innerHTML = '비밀번호 불일치'		
	} else{ div.innerHTML = ' '; }
}

function pwdChange(){
	var frm = $('#frm_pwd')[0];
	var div = document.getElementById('pwdChk');
	var param = $(frm).serialize();
	
	 // 회원가입 입력 확인
	if(frm.pwd.value == ""){alert('현재 비밀번호를 입력해주세요')}
	else if(frm.new_pwd.value == ""){alert('새 비밀번호를 입력해주세요')}
	else if(div.innerText.trim()=='비밀번호 불일치'){alert('비밀번호 일치 여부를 확인해주세요')}
	else{	
	    $.ajax({
			type : 'post',
			data : param,
			url : '../../account/pwdChk.act',
			success(resp){
				if(resp=='true'){
					opener.$('#frm_manager').load('../../account/pwdChange.act', param);
					alert('비밀번호가 변경 되었습니다.')
					self.close()
				}else{
					alert("현재 비밀번호가 일치하지 않습니다.")
					}
				}
				})  
		}
}

</script>
</body>
</html>