/**
 *  생활 방역 게시판 자바 스크립트
 */
 
 var sang = {};
sang.init = function(){
	
	$('#btnSearch').on('click',function(){
		var frm = $('#frm_sang')[0];
		var param = $(frm).serialize();
		
		$('#sang').load('search.sanghwal', param);
	})
	
	$('#sang #btnFind').on('click', function(){
		var frm = $('#frm_sang')[0];
		frm.nowPage.value = 1;
		var param = $(frm).serialize();
		
		$('#sang').load('search.sanghwal', param);
	})
}

sang.view = function(serial){
	var frm = $('#frm_sang')[0];
	frm.serial.value=serial;
	var param = $(frm).serialize();
	
	$('#sang').load('view.sanghwal', param);
}


sang.move = function(nowPage){
	var frm = $('#frm_sang')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
		
	$('#sang').load('search.sanghwal', param);
}