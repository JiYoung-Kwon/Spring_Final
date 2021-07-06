/**
 * 	페이지 이동을 위한 js
 */
 
var brd={};
/*  ------------------ 페이지 이동 ---------------------*/
brd.move = function (nowPage){	
	 var tabGubun = document.getElementById('tabGubun').value;
	 var findStr = document.getElementById('findStr').value;

	 var param = "tabGubun="+tabGubun+"&findStr="+findStr+"&nowPage="+nowPage;

	 $('#middle').load('./NI/search.brd', param);
}

/*  ------------------------------------------------  */		

/* 메인 페이지에서 테스트 해보기 위함.*/
brd.init = function(){
	 var tabGubun = document.getElementById('tabGubun').value;
	 var nowPage = document.getElementById('nowPage').value; 
     var findStr = document.getElementById('findStr').value;

	 var param = "tabGubun="+tabGubun+"&nowPage="+nowPage+"&findStr="+findStr;
	
	$('#btnIssue').on('click', function(){
		$('#middle').load('./NI/search.brd?tabGubun=issue',param);
	})
	
	$('#btnNews').on('click', function(){
		$('#middle').load('./NI/search.brd?tabGubun=news' ,param);
	})
	
	$('#btnHobby').on('click', function(){
		$('#middle').load('./NI/search.brd?tabGubun=hobby' ,param);
	})		
	
	
	
	}
/* ----------페이지에서 버튼으로 다른 페이지를 이동하기 위함-------------*/	

tab = function(tabName){
	
	switch(tabName){
		case 'issue' :
		$('#middle').load('./NI/search.brd?tabGubun=issue');
		break;
		case 'news' :
		$('#middle').load('./NI/search.brd?tabGubun=news');
		break;
		case 'hobby' :
		$('#middle').load('./NI/search.brd?tabGubun=hobby');
		break;
			
	}
}
	

	
/* ---------------상세 보기 뒤로가기 -----------------*/
brd.back = function(){
	 
	 var tabGubun = document.getElementById('tabGubun').value;
	 var nowPage = document.getElementById('nowPage').value; 
     var findStr = document.getElementById('findStr').value;

	 var param = "tabGubun="+tabGubun+"&nowPage="+nowPage+"&findStr="+findStr;
  	 
		$('#middle').load('./NI/search.brd', param);
}
	
/* ---------------- 상세보기 페이지  ----------------*/	
brd.view = function(serial){
	
 	 var tabGubun = document.getElementById('tabGubun').value;
	 var nowPage = document.getElementById('nowPage').value;

	 var param = "tabGubun="+tabGubun+"&nowPage="+nowPage+"&serial="+serial;
	 $('#middle').load('./NI/View.brd', param);

}

 

/* ---------------- 검색창  ----------------*/	
var search = document.getElementById('search')

search.onclick = function(){
	 var tabGubun = document.getElementById('tabGubun').value;
	 var findStr = document.getElementById('findStr').value;
	
	
	 var param = "tabGubun="+tabGubun+"&findStr="+findStr+"&nowPage="+'1';

	$('#middle').load('./NI/search.brd',param);
}	




	
