<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>내 주변 병원 찾기</title>
<link rel='stylesheet' type='text/css' href='../css/map.css'>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='../js/map.js'></script>
</head>
<body>
<div id='publicHospital'>
   <form name='frm_publicHospital' id='frm_publicHospital' method='post'>
      <div id='tab_container' class='tab_container'>
	      <div id='tab_menu'>
	      <ul id='tab_title' class='tab_title'>
	         <li class='on_tab'>국민안심병원</li>
	         <li>선별진료소</li>
	         <li>코로나검사 실시기관</li>
	      </ul>
	      </div>
	      
	      <div id='tab_cont' class='tab_cont'>
		  	<div class='on_tab'>
		    	국민안심병원 내용
		    </div>
	      	<div>
	      		선별진료소 내용
	      	</div>
			<div>
				코로나검사 실시기관 내용
			</div>	      
	      </div>
	      
	      <div id='tab_text' class='tab_text'>
	      	<div class='on_tab'>
	      		<h3 class='identify'>내 주변 안심병원 찾기 </h3>
	      	</div>
	      	<div>
	      		<h3 class='identify'>내 주변 선별진료소 찾기</h3>
	      	</div>
	      	<div>
	      		<h3 class='identify'>내 주변 코로나검사 기관 찾기</h3>
	      	</div>
	      
	      </div>
			
      </div>
         
         
            
         
         
      
      
      
      <div id='notice'>
         <div id='noticeforhospital'>
            <span class='referencemark'>※</span>
            <div id='noticeforhospital_text'></div>
         </div>
         <span class='referencemark'>
         ※ "선별진료소"는 코로나19가 의심되거나 역학적 연관성이 있는 사람에게 코로나19 검사를 실시하는 곳입니다.
         </span><br>
         <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
         </ul>
      
      </div>
   
   
   
   </form>

</div>


</body>
</html>