function init(){
		var login = document.getElementById('login_id').value

		if (login=='null'){
			alert('로그인이 필요합니다.')
			location.href='./manager_loginform.jsp'
		}
}

/*페이지 이동*/
function accountPageMove(nowPage){
	var frm = $('#account_board_frm')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
	$('#frm_manager').load('../../account/search.act', param);
};


// 현재페이지 버튼 색상 넣기
function initAccount(){
		
	var btn = document.getElementsByClassName('page_button')
	var nowPage = document.getElementById('nowPage').value
	
	for(var i=0;i<btn.length;i++){
		if(btn[i].value == nowPage){
			btn[i].className = 'now_btn';
		}
	}
}

// 계정정보 view 페이지 이동
function accountView(num){
	var item = $('.account_items')[num];
	var nowPage = document.getElementById('nowPage').value;
	var findStr = document.getElementById('findStr').value;
	var param = "mid="+item.childNodes[1].innerText+"&nowPage="+nowPage+"&findStr="+findStr;
	
	$('#frm_manager').load('../../account/view.act', param);
	
}

// 정보 수정
function accountUpdate(){
	var frm = $('#account_board_frm')[0];
	var param = $(frm).serialize();
	
	if(confirm("정보를 수정하시겠습니까?")){
	$('#frm_manager').load('../../account/update.act', param);
	alert('변경 되었습니다.')
	}
}

// 비밀번호 변경 창 생성
function accountpwd(){
	var win = window.open("../account/pwd.jsp", "비밀번호 변경창", "width = 450, height = 145");
	var mid = document.account_board_frm.mid.value;
	var nowPage = document.getElementById('nowPage').value;
	var findStr = document.getElementById('findStr').value;

	win.onload = function(){
		win.frm_pwd.mid.value = mid;
		win.frm_pwd.nowPage.value = nowPage;
		win.frm_pwd.findStr.value = findStr;
	}
}

// 계정 삭제
function accountdelete(){
	var frm = $('#account_board_frm')[0];
	var param = $(frm).serialize();
	
	if(confirm("정말 삭제하시겠습니까?")){
	$('#frm_manager').load('../../account/delete.act', param);
	alert('삭제 되었습니다.')
	}
}

// 목록 페이지로 리턴
function accountReturn(){
	var frm = $('#account_board_frm')[0];
	var param = $(frm).serialize();
	$('#frm_manager').load('../../account/return.act', param);
}

// 계정 생성 페이지 이동
function registerPageMove(){
	var frm = $('#account_board_frm')[0];
	var param = $(frm).serialize();

	
	$('#frm_manager').load('../../account/register.act', param);
	
}

// 계정 생성
function accountInsert(){
	
	var frm = $('#account_board_frm')[0];
	var div = document.getElementById('pwdChk');
	var param = $(frm).serialize();
	var idChk = document.getElementById('id_chk').value
	
	 // 회원가입 입력 확인
	if(frm.mid.value == ""){alert('아이디를 입력해주세요')}
	else if(frm.mname.value == ""){alert('이름을 입력해주세요')}
	else if(frm.pwd.value == ""){alert('비밀번호를 입력해주세요')}
	else if(div.innerText.trim()=='비밀번호 불일치'){alert('비밀번호 일치 여부를 확인해주세요')}
	else if(frm.mjob.value == ""){alert('업무명을 입력해주세요')}
	else if(frm.mposition.value == ""){alert('직책을 입력해주세요')}
	else if(idChk == 'false'){alert('아이디 중복 여부를 확인해주세요')}
	else{	$('#frm_manager').load('../../account/insert.act', param);
			alert('계정이 생성 되었습니다.') 
	}

}

// 아이디 중복 여부 체크 리셋
$('#mid').keyup(function(){        // 아이디가 변경될때마다.
	var idChk = document.getElementById('id_chk')
	idChk.value = 'false';   // 체크값을 false로 변경 (새로 중복체크 해야함)
})

// 중복체크
function idChk(){   // 중복 체크 후 사용 가능하면 idchk값 true 로 변환
	var mid = document.getElementById('mid').value;
	var idChk = document.getElementById('id_chk')
	var mid2 = mid.split(" ");
	var param = 'mid='+mid
	
	if(mid!=''&&mid2.length<2){
	$.ajax({
		type : 'post',
		data : param,
		url : '../../account/idChk.act',
		success(resp){
			if(resp>0){
				alert("중복된 아이디입니다.")
				idChk.value = 'false';
			}else{
				alert("사용 가능한 아이디입니다.")
				idChk.value = 'true';
				}
			}
		})
	}else{alert('아이디를 확인해주세요')}
}


// 비밀번호 불일치 문구
function passwordChk(){
	var pwd = document.getElementById('pwd').value;
	var pwd2 = document.getElementById('pwd2').value;
	var div = document.getElementById('pwdChk') 

	if(pwd!=pwd2){
		div.innerHTML = '비밀번호 불일치'		
	} else{ div.innerHTML = ' '; }
}