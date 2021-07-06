// 이전 버튼
$('#btn_left').on({ 'click': function(){ 
	
	var btn = document.getElementById('btn_num')
	var num = btn.value
	
	switch(num){
	case "1" :
		var src = "./img/banner3.png"
		break;
	case "2" :
		var src = "./img/banner1.png"
		break;
	case "3" :
		var src = "./img/banner2.png"
		break;
	}
	
	if(Number(num)-1==0){
		num=4
	}
	
	btn.value = Number(num)-1
	
	$("#banner_img").attr("src", src);

} });

//다음 버튼

$('#btn_right').on({ 'click': function(){ 
	
	var btn = document.getElementById('btn_num')
	var num = btn.value
	
	switch(num){
	case "1" :
		var src = "./img/banner2.png"
		break;
	case "2" :
		var src = "./img/banner3.png"
		break;
	case "3" :
		var src = "./img/banner1.png"
		break;
	}
	
	if(Number(num)+1==4){
		num=0
	}
	
	btn.value = Number(num)+1
	
	$("#banner_img").attr("src", src);
	
	
	

} });

function banner (){
	var btn = document.getElementById('btn_num')
	var num = btn.value
	
	switch(num){
	case "1" :	
		window.open('http://www.naver.com','_blank');
		break;
	case "2" :
		window.open('http://www.naver.com','_blank');
		break;
	case "3" :
		window.open('https://www.youtube.com/watch?v=lRluKO3UuCw','_blank');
		break;
	}
}

// 4초에 한번 배너 변경 
setInterval(function(){
	$("#btn_right").trigger("click");
},4000);

// 공지사항 페이지 이동
function unoticePageGo(){
	$('#middle').load('notice/ureader.notice');
}

$('#logo_IF').on({ 'click': function(){ 
	location.href = './index.jsp';
}}
)
