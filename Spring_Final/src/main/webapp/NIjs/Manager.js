/*  ------------------ 페이지 이동 ---------------------*/
brd.move = function (nowPage){	
	 var tabGubun = document.getElementById('tabGubun').value;
	 var findStr = document.getElementById('findStr').value;

	 var param = "tabGubun="+tabGubun+"&findStr="+findStr+"&nowPage="+nowPage;

	 $('#frm_manager').load('../../NI/search.brd', param);
}



/*  ------------------------------------------------  */		

/* 메인 페이지에서 테스트 해보기 위함.*/
brd.init = function(){
	
	$('#Issue_Board #Create').on('click', function(){
		var frm = $('#Issue_board_frm')[0];
		var param = $(frm).serialize();
		
		$('#frm_manager').load('../../NI/Create_form.jsp', param);
	})
	
	$('#News_Board #Create').on('click', function(){
		var frm = $('#News_board_frm')[0];
		var param = $(frm).serialize();
		
		$('#frm_manager').load('../../NI/Create_form.jsp', param);
	})
	
	$('#hobby_Board #CreateM').on('click', function(){
		var frm = $('#hobby_board_frm')[0];
		var param = $(frm).serialize();
		
		$('#frm_manager').load('../../NI/Create_form.jsp', param);
	})

	
	$('#Create_footer_frm #Create_save').on('click', function(){
	editor_object.getById['Create_area'].exec('UPDATE_CONTENTS_FIELD',[]);
	var titleOK = document.getElementById('Create_title2').value;
	
	var docOK = document.getElementById('Create_area').value;
	if(titleOK == 0){
		alert('제목을 입력하세요.');
	}else if(titleOK.length > 50){
		alert('25자 이하로 입력해 주세요.');
	}else if(docOK == '<p><br></p>'){
		alert('1글자 이상 입력하세요.');
	}else{	
		var frm = $('#Create_form')[0];
		var param = $(frm).serialize();
		$('#frm_manager').load('../../NI/Create.brd', param);
			
	}
 })	

/*수정*/
	$('#Update_footer_frm #Update').on('click', function(){ 
	editor_object.getById['Update_create_area'].exec('UPDATE_CONTENTS_FIELD',[]);
	var titleOK = document.getElementById('Update_title2');
	var docOK = document.getElementById('Update_create_area');
	if(titleOK.value == 0){
		alert('제목을 입력하세요.');
	}else if(titleOK.value.length >= 25){
		alert('25자 이하로 입력해 주세요.');
	}else if(docOK.value == '<p><br></p>'){
		alert('1글자 이상 입력하세요.');
	}else{
		var compare = document.getElementById('Update_ok');
		var yes = document.getElementById('update_yes');
		var no = document.getElementById('update_no');
		compare.style.display = 'inline-block';
		yes.onclick = function(){
			var frm = $('#Update_form')[0];
			var param = $(frm).serialize();
			
			$.ajax({
				type	:	'POST',
				data	:	param,
				url		:	'../../NI/Update.brd',
				success	:	function() {
					$('#frm_manager').load('../../NI/search.brd', param);
				}
			});
		};
		no.onclick = function(){
			compare.style.display = 'none';
		};
	}

})

/*삭제*/
	
	$('#Update_footer_frm #Update_delete').on('click',function(){
	var frm = $('#Update_form')[0];
	var param = $(frm).serialize();
	var compare = document.getElementById('Update_delete_ok');
	var yes = document.getElementById('delete_yes');
	var no = document.getElementById('delete_no');
	compare.style.display = 'inline-block';
	yes.onclick = function(){
		$.ajax({
			type	:	'POST',
			data	:	param,
			url		:	'../../NI/Delete.brd',
			success	:	function() {
				$('#frm_manager').load('../../NI/search.brd', param);
			}
		});
	};
	no.onclick = function(){
		compare.style.display = 'none';
	};
})
	
	$('#Update_footer_frm #Update_back').on('click', function(){
		var frm = document.getElementById('tabGubun');
		var param = $(frm).serialize();
		$('#frm_manager').load('../../NI/search.brd',param);
	})
	
	$('#Create_footer_frm #Create_back').on('click', function(){
		var frm = document.getElementById('tabGubun');
		var param = $(frm).serialize();
		$('#frm_manager').load('../../NI/search.brd',param);
	})
	
};

/*삭제*/
/*수정*/

/* ----------페이지에서 버튼으로 다른 페이지를 이동하기 위함-------------*/	

tab = function(tabName){
	
	switch(tabName){
		case 'issue_M' :
		$('#frm_manager').load('../../NI/search.brd?tabGubun=issue_M');
		break;
		case 'news_M' :
		$('#frm_manager').load('../../NI/search.brd?tabGubun=news_M');
		break;
		case 'hobby_M' :
		$('#frm_manager').load('../../NI/search.brd?tabGubun=hobby_M');
		break;
	}
}
	

	
/* ---------------상세 보기 뒤로가기 -----------------*/
brd.back = function(){
	 
	 var tabGubun = document.getElementById('tabGubun').value;
	 var nowPage = document.getElementById('nowPage').value; 
     var findStr = document.getElementById('findStr').value;

	 var param = "tabGubun="+tabGubun+"&nowPage="+nowPage+"&findStr="+findStr;
  	 
		$('#frm_manager').load('../../NI/search.brd', param);
}
	
/* ---------------- 상세보기 페이지  ----------------*/	
brd.view = function(serial){
	
 	 var tabGubun = document.getElementById('tabGubun').value;
	 var nowPage = document.getElementById('nowPage').value;

	 var param = "tabGubun="+tabGubun+"&nowPage="+nowPage+"&serial="+serial;
	 $('#frm_manager').load('../../NI/View.brd', param);
}





/* ---------------- 검색창  ----------------*/	
var search = document.getElementById('search')

search.onclick = function(){
	 var tabGubun = document.getElementById('tabGubun').value;
	 var findStr = document.getElementById('findStr').value;
	
	
	 var param = "tabGubun="+tabGubun+"&findStr="+findStr+"&nowPage="+'1';

	$('#frm_manager').load('../../NI/search.brd',param);
}	
