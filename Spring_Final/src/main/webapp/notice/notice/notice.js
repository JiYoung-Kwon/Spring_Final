/*페이지 이동*/
function UNoticePageMove(nowPage){
	var frm = $('#unotice_search_frm')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
	$('#middle').load('notice/ureader.notice', param);
};

function MNoticePageMove(nowPage){
	var frm = $('#mnotice_search_frm')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
	$('#frm_manager').load('../../notice/mreader.notice', param);
};
/*페이지 이동*/

/*검색*/
function UNoticeClickAction(){
	var frm = $('#unotice_search_frm')[0];
	frm.nowPage.value = 1;
	var param = $(frm).serialize();
	$('#middle').load('notice/ureader.notice', param);
};
function UNoticeEnterAction(event){if(event.keyCode == 13){UNoticeClickAction();};};

function MNoticeClickAction(){
	var frm = $('#mnotice_search_frm')[0];
	frm.nowPage.value = 1;
	var param = $(frm).serialize();
	$('#frm_manager').load('Spring_Final/notice/mreader.notice', param);
};
function MNoticeEnterAction(event){if(event.keyCode == 13){MNoticeClickAction();};};
/*검색*/

/*상세보기*/
function UNoticeView(serial){
	var frm = $('#unotice_search_frm')[0];
	frm.serial.value = serial;
	var param = $(frm).serialize();
	$('#middle').load('notice/uview.notice', param);
};
function UNoticeViewBack(){
	var frm = $('#unotice_view_frm')[0];
	var param = $(frm).serialize();
	$('#middle').load('notice/ureader.notice', param);
};

function MNoticeView(serial){
	var frm = $('#mnotice_search_frm')[0];
	frm.serial.value = serial;
	var param = $(frm).serialize();
	$('#frm_manager').load('Spring_Final/notice/mview.notice', param);
};
function MNoticeViewBack(){
	var frm = $('#mnotice_update_form')[0];
	var param = $(frm).serialize();
	$('#frm_manager').load('Spring_Final/notice/mreader.notice', param);
};
/*상세보기*/

/*입력 폼 바로가기*/
function MNoticeCreateGo(){
	var frm = $('#mnotice_search_frm')[0];
	$(frm).findStr = '';
	var param = $(frm).serialize();
	$('#frm_manager').load('Spring_Final/notice/mcview.notice', param);
};
function MNoticeCreateBack(){
	var frm = $('#mnotice_create_form')[0];
	var param = $(frm).serialize();
	$('#frm_manager').load('Spring_Final/notice/mreader.notice', param);
};
/*입력 폼 바로가기*/

/*입력*/
function MNoticeCreate(){
	editor_object.getById['mnotice_create_area'].exec('UPDATE_CONTENTS_FIELD',[]);
	var titleOK = document.getElementById('mnotice_title2');
	var docOK = document.getElementById('mnotice_create_area');
	
	if(titleOK.value == 0){
		alert('제목을 입력하세요.');
	}else if(titleOK.value.length >= 25){
		alert('25자 이하로 입력해 주세요.');
	}else if(docOK.value == '<p><br></p>'){
		alert('1글자 이상 입력하세요.');
	}else{
		var compare = document.getElementById('mnotice_create_ok');
		var yes = document.getElementById('create_yes');
		var no = document.getElementById('create_no');
		compare.style.display = 'inline-block';
		yes.onclick = function(){
			var frm = $('#mnotice_create_form')[0];
			var param = $(frm).serialize();
			$.ajax({
				type	:	'POST',
				data	:	param,
				url		:	'Spring_Final/notice/mcreate.notice',
				success	:	function() {
					$('#frm_manager').load('Spring_Final/notice/mreader.notice', param);
				}
			});
		};
		no.onclick = function(){
			compare.style.display = 'none';
		};
	}
};
/*입력*/

/*수정*/
function MNoticeUpdate(){
	editor_object.getById['mnotice_create_area'].exec('UPDATE_CONTENTS_FIELD',[]);
	var titleOK = document.getElementById('mnotice_title2');
	var docOK = document.getElementById('mnotice_create_area');
	if(titleOK.value == 0){
		alert('제목을 입력하세요.');
	}else if(titleOK.value.length >= 25){
		alert('25자 이하로 입력해 주세요.');
	}else if(docOK.value == '<p><br></p>'){
		alert('1글자 이상 입력하세요.');
	}else{
		var compare = document.getElementById('mnotice_update_ok');
		var yes = document.getElementById('update_yes');
		var no = document.getElementById('update_no');
		compare.style.display = 'inline-block';
		yes.onclick = function(){
			var frm = $('#mnotice_update_form')[0];
			var param = $(frm).serialize();
			$.ajax({
				type	:	'POST',
				data	:	param + '&updatecompare=수정됨',
				url		:	'Spring_Final/notice/mupdate.notice',
				success	:	function() {
					$('#frm_manager').load('Spring_Final/notice/mreader.notice', param);
				}
			});
		};
		no.onclick = function(){
			compare.style.display = 'none';
		};
	}
};
/*수정*/

/*삭제*/
function MNoticeDelete(){
	var frm = $('#mnotice_update_form')[0];
	var param = $(frm).serialize();
	var compare = document.getElementById('mnotice_delete_ok');
	var yes = document.getElementById('delete_yes');
	var no = document.getElementById('delete_no');
	compare.style.display = 'inline-block';
	yes.onclick = function(){
		$.ajax({
			type	:	'POST',
			data	:	param,
			url		:	'Spring_Final/notice/mdelete.notice',
			success	:	function() {
				$('#frm_manager').load('Spring_Final/notice/mreader.notice', param);
			}
		});
	};
	no.onclick = function(){
		compare.style.display = 'none';
	};
};
/*삭제*/