<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>내 주변 병원 찾기</title>
<link rel='stylesheet' type='text/css' href='/Spring_Final/mapCss/map.css'>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='/Spring_Final/mapJs/map.js'></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDXhZaX8CEwnJKpNAYp9aiLMIK2tl-yngw&callback=initMap&region=kr"></script>
</head>
<body>
<div id='wrapper'>
	<div class='left_side'></div>
	
	<div id='findMap'>
	      <input type="hidden" id="gubunval" value="${gubunval }">
	      <div id='tab_container'>
		      <div class='tab_menu'>
		      	<ul class='tab_title'>
			         <li id='hospital'>국민안심병원</li>
			         <li id='carecenter'>선별진료소</li>
			         <li id='testagency'>코로나검사 실시기관</li>
		      	</ul>
		      </div>
		      
		      <div class='tab_cont'>
				  	<div class='tab_body'>
				   	<div class='hospital_text' >
				   		<span class='mark'>※</span>
				   		<span class='hospital_text_body'>"국민안심병원"은 병원 내 감염으로부터 환자를 안전하게 보호하기 위하여 호흡기 환자와 비(非)호흡기 환자를 분리하여 진료하는 곳입니다.</span>
				   		<br/>
				   		<span class='mark'>※</span>
				   		<span class='hospital_text_body1'>선정유형</span><br>
				   		<span class='hospital_text_body2'>A: 일반 호흡기 환자 진료를 위한 호흡기 전용 외래 설치 운영 병원</span><br>
				   		<span class='hospital_text_body3'>B: 호흡기 환자 전용 외래입원 진료가 가능한 선별진료소 운영 병원</span>
				   		
				   	</div>
				   	
				   	<div class='img_wrapper'>
				   		
				   		<div class='mask'>
				   			<img class='mask_img' src='/Spring_Final/img/mask.png' >
								<span class='mask_text'>마스크 착용</span>
							</div>
							
							<div class='sanitizer'>
								<img class='sanitizer_img' src='/Spring_Final/img/sanitizer.png'>
								<span class='sanitizer_text'>손 소독</span>
							</div>
							
							<div class='thermometer'>
								<img class='thermometer_img' src='/Spring_Final/img/thermometer.png'>
								<span class='thermometer_text'>비접촉 체온측정</span>
							</div>
							
							<div class='doctor'>
								<img class='doctor_img' src='/Spring_Final/img/doctor.png'>
								<span class='thermometer_text'>의료진 의사소통</span>
							</div>
							
							<div class='distancing'>
								<img class='distancing_img' src='/Spring_Final/img/distancing.png'>
								<span class='distancing_text'>거리두기</span>
							</div>
							
				   	</div>
				   	
				   </div>
			   	
			   	<div class='tab_body'>
			      	<div class='carecenter_text' >
				   		<span class='mark'>※</span>
				   		<span class='carecenter_text_body'>"선별진료소"는 코로나19가 의심되거나 역학적 연관성이 있는 사람에게 코로나19 검사를 실시하는 곳입니다.</span>
				   		<br/>
				   		<span class='mark'>※</span>
				   		<span class='carecenter_text_body1'>조사대상 유증상자</span><br>
				   		<span class='carecenter_text_body2'>① 의사의 소견에 따라 코로나19 임상증상으로 코로나19가 의심되는 자</span><br>
				   		<span class='carecenter_text_body3'>② 해외 방문력이 있으며 귀국 후 14일 이내에 코로나19 임상증상이 나타난 자</span>
				   		<span class='carecenter_text_body4'>③ 코로나바이러스감염증-19 국내 집단발생과 역학적 연관성이 있으며, 14일 이내 코로나19 임상증상이 나타난 자</span>
				   		
				   	</div>
				   	
				   	<div class='img_wrapper'>
				   		
				   		<div class='mask'>
				   			<img class='mask_img' src='/Spring_Final/img/mask.png' >
								<span class='mask_text'>마스크 착용</span>
							</div>
							
							<div class='sanitizer'>
								<img class='sanitizer_img' src='/Spring_Final/img/sanitizer.png'>
								<span class='sanitizer_text'>손 소독</span>
							</div>
							
							<div class='thermometer'>
								<img class='thermometer_img' src='/Spring_Final/img/thermometer.png'>
								<span class='thermometer_text'>비접촉 체온측정</span>
							</div>
							
							<div class='doctor'>
								<img class='doctor_img' src='/Spring_Final/img/doctor.png'>
								<span class='thermometer_text'>의료진 의사소통</span>
							</div>
							
							<div class='distancing'>
								<img class='distancing_img' src='/Spring_Final/img/distancing.png'>
								<span class='distancing_text'>거리두기</span>
							</div>
							
				   	</div>
				   	
			      </div>
					
					<div class='tab_body'>
						<div class='testagency_text' >
				   		<span class='mark'>※</span>
				   		<span class='testagency_text_body1'>코로나바이러스감염증-19 검사를 수행할 수 있는 의료기관입니다.</span>
				   		<br/>
				   		<span class='mark'>※</span>
				   		<span class='testagency_text_body2'>코로나바이러스감염증-19 검사시행 의료기관은「감염병의 예방 및 관리에 관한 법률」제16조의2제2항에 따라 실험실 검사능력 평가를 완료한 기관입니다.</span><br>
				   		<span class='mark'>※</span>
				   		<span class='testagency_text_body3'>검사가능 의료기관은 각 기관의 사정에 따라 변경될 수 있으며, 검사 개시일은 의료기관의 여건에 따라 다를 수 있습니다.</span><br>
				   		
				   	</div>
				   	
				   	<div class='img_wrapper'>
				   		
				   		<div class='mask'>
				   			<img class='mask_img' src='/Spring_Final/img/mask.png' >
								<span class='mask_text'>마스크 착용</span>
							</div>
							
							<div class='sanitizer'>
								<img class='sanitizer_img' src='/Spring_Final/img/sanitizer.png'>
								<span class='sanitizer_text'>손 소독</span>
							</div>
							
							<div class='thermometer'>
								<img class='thermometer_img' src='/Spring_Final/img/thermometer.png'>
								<span class='thermometer_text'>비접촉 체온측정</span>
							</div>
							
							<div class='doctor'>
								<img class='doctor_img' src='/Spring_Final/img/doctor.png'>
								<span class='thermometer_text'>의료진 의사소통</span>
							</div>
							
							<div class='distancing'>
								<img class='distancing_img' src='/Spring_Final/img/distancing.png'>
								<span class='distancing_text'>거리두기</span>
							</div>
							
				   	</div>
						
					</div>	      
		      </div>
		      
		      <div class='tab_text'>
		      	<div class='tab_identify'>
		      		<h3 class='identify'>내 주변 안심병원 찾기 </h3>
		      	</div>
		      	<div class='tab_identify'>
		      		<h3 class='identify'>내 주변 선별진료소 찾기</h3>
		      	</div>
		      	<div class='tab_identify'>
		      		<h3 class='identify'>내 주변 코로나검사 실시기관 찾기</h3>
		      	</div>
		      </div>
				
	      </div>
	      
	      <div id='search_area' class='search_area'>   
				<div class='list_menu'>
					<div>
						<h3 class='list_identify'>국민안심병원</h3>			
					</div>
					<div>
						<h3 class='list_identify'>선별진료소</h3>
					</div>
					<div>
						<h3 class='list_identify'>코로나검사 실시기관</h3>
					</div>
				
				</div>
				
				<div class='find_cont'>
					
					<form name="frm_search" id="frm_search" action="" method="post">
						<div class='find_box'>
							<div class='row'>
								<div class='selcity'>
									<select name="sido" id="sido"></select>
									<select name="sigungu" id="sigungu"></select>
								</div>
							</div>
							
							<!-- <div class='sidoChoose'>시도내용</div>
							<div class='sigunguChoose'>시군구내용</div> -->
							
							<div class='search_text'>
								<input type='text' id='findStr' name='findStr'/>
								<input type='button' id='btnSearch' class='btnSearch' value='검색' onclick="search()"/>
							</div>
							<input type="hidden" id="hp_gubun" name="hpGubun" value="${hpGubun }">
						</div>
					</form>	
					
					<div class='title'>
						총 
						<em class='numOfSearch'></em>
						건이 검색되었습니다.
					</div>
					
					<div id='search_result' class='search_result'>
						
					</div>
				</div>
	      </div>
	         
	      <div id='map_area' class='map_area'>
	      
	      
	      </div>
	      
   	</div>
	
	<div class='right_side'></div>
</div>
<script type="text/javascript">tapinit()</script>
</body>
</html>