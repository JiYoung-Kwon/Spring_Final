var brd={};

function MNoticeGoPage(){
	$('#frm_manager').load('../../notice/mreader.notice');
};

function MsanghwalGO(){
	$('#frm_manager').load('../../msanghwal/msanghwal_search.msanghwal');
};


function init(){
		var login = document.getElementById('login_id').value

		if (login=='null'){
			alert('로그인이 필요합니다.')
			location.href='./manager_loginform.jsp'
		}
		
		$("#btnmanager").trigger("click");
}
function account(){
		$('#frm_manager').load('../../account/search.act');
	}
	
function login(){
	var frm = $('#login_frm')[0];
	var param = $(frm).serialize();
	$.ajax({
			type : 'post',
			data : param,
			url : '../../account/login.act',
			success(resp){                               // 로그인 성공시
				if(resp=='true'){
					location.href='./manager_main.jsp'    // 페이지 전환
					}else{
						alert('입력하신 정보가 일치하지 않습니다.') // 로그인 실패시
					}
				}
})
}
function logout(){
	
	$.ajax({
			type : 'post',
			url : './logout.jsp',
			success(resp){
				alert('로그아웃 되었습니다.')
				location.href='./manager_loginform.jsp'
			      }                 
	})
}



	

