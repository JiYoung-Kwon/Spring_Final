/**
 * 
 */

function tapinit(){
	var gubun = document.getElementById('gubunval').value;
	
	switch(gubun){
			case '0':
			$(document).ready(function(){
				$('.tab_menu #hospital').bind('click', function(){
				});
				$('.tab_menu #hospital').trigger('click');
			});
			break;
			case '1':
			$(document).ready(function(){
				$('.tab_menu #carecenter').bind('click', function(){
				});
				$('.tab_menu #carecenter').trigger('click');
			});
			break;
			case '2':
			$(document).ready(function(){
				$('.tab_menu #testagency').bind('click', function(){
				});
				$('.tab_menu #testagency').trigger('click');
			});
			break;
	}
	
}


$(document).ready(function(){
	$('.tab_title li').click(function(){
		var idx = $(this).index();
		
		var frm = $('#frm_search')[0];
		var hpGubun = frm.hpGubun;
		
	switch(idx){
			case 0:
			hpGubun.value = 'A0'
			break;
			case 1:
			hpGubun.value = '99'
			break;
			case 2:
			hpGubun.value = '97'
			break;
	}
			
		$('.tab_title li').removeClass('on_tab');
		$('.tab_title li').eq(idx).addClass('on_tab');
		$('.tab_cont .tab_body').hide();
		$('.tab_cont .tab_body').eq(idx).show();
		$('.tab_text > div').hide();
		$('.tab_text > div').eq(idx).show();
		$('.list_menu > div').hide();
		$('.list_menu > div').eq(idx).show();
	})
});


$(document).ready(function() {
   var area0  = ["시/도 선택","서울","인천","대전","광주","대구","울산","부산","경기","강원","충청","충남","전북","전남","경북","경남","제주도"];
   var area1  = ["시/군/구 선택","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
   var area2  = ["시/군/구 선택","계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
   var area3  = ["시/군/구 선택","대덕구","동구","서구","유성구","중구"];
   var area4  = ["시/군/구 선택","광산구","남구","동구",     "북구","서구"];
   var area5  = ["시/군/구 선택","남구","달서구","동구","북구","서구","수성구","중구","달성군"];
   var area6  = ["시/군/구 선택","남구","동구","북구","중구","울주군"];
   var area7  = ["시/군/구 선택","강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
   var area8  = ["시/군/구 선택","고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
   var area9  = ["시/군/구 선택","강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
   var area10 = ["시/군/구 선택","제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
   var area11 = ["시/군/구 선택","계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
   var area12 = ["시/군/구 선택","군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
   var area13 = ["시/군/구 선택","광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
   var area14 = ["시/군/구 선택","경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
   var area15 = ["시/군/구 선택","거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
   var area16 = ["시/군/구 선택","서귀포시","제주시","남제주군","북제주군"];

 // 시/도 선택 박스 초기화
 $("select[name^=sido]").each(function() {
  $selsido = $(this);
  $.each(eval(area0), function() {
   $selsido.append("<option value='"+this+"'>"+this+"</option>");
  });
  $selsido.next().append("<option value=''>시/군/구 선택</option>");
 });

 // 시/도 선택시 시/군/구 설정
 $("select[name^=sido]").change(function() {
  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 시군구 Array
  var $sigungu = $(this).next(); // 선택영역 시군구 객체
  $("option",$sigungu).remove(); // 시군구 초기화

  if(area == "area0")
   $sigungu.append("<option value=''>시/군/구 선택</option>");
  else {
   $.each(eval(area), function() {
    $sigungu.append("<option value='"+this+"'>"+this+"</option>");
   });
  }
 });

});


function search(){
	var frm = $('#frm_search')[0];
	var param = $(frm).serialize();
	
	$('#search_result').load('search.hospital', param);
	
	var sido = $('#sido option:selected').text();
	var sigungu = $('#sigungu option:selected').text();
	
	if(sido == '시/도 선택'){
		alert("시/도를 선택해주세요.")
		/*$('.sidoChoose').show();*/
	} else if(sigungu == '시/군/구 선택'){
		alert("시/군/구를 선택해주세요.")
	} 
}

function initMap() {
      var seoul = { lat: 37.5642135 ,lng: 127.0016985 };
      var map = new google.maps.Map(
        document.getElementById('map_area'), {
          zoom: 14,
          center: seoul
    });
}

/*지오코딩 api키 : AIzaSyApFUNTAVof33a46pXOgxUTxE6qh_vJASM*/
/*map javascript api키 : AIzaSyDXhZaX8CEwnJKpNAYp9aiLMIK2tl-yngw*/






$('#submit').on('click',function(){
	
	var addr =  document.getElementById('addr').innerText
	var hp = document.getElementById('hp_gubun').value

	var param = "address="+addr+"&hpGubun="+hp;

	$.ajax({

		type: 'post',
		url : 'mark.hospital',
		data : param,
		success: function(resp){
			var a = resp.trim().split(',');

		 var center = {lat: Number(a[1]) ,lng: Number(a[0]) };       
			
		    var map = new google.maps.Map(document.getElementById('map_area'), {

		        zoom: 17,

			    center: center

		      });


		    var marker = new google.maps.Marker({position: center, map: map});

		}

	})

	
})






















