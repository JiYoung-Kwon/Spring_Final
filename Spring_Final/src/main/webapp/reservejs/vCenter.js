/**
 * 
 */
// 오늘 날짜 지정
function time() {
	var date = document.getElementById('date')
	date.valueAsDate = new Date();
}

// 처음 로드시
function load() {

	// 시/도 가져오기
	$.ajax({
		type: 'post',
		url: "./sido.vCenter",
		success: function(resp) {
			var resp = resp.trim().split(',');
			for (var i = 0; i < resp.length - 1; i++) {
				$('#sido').append('<option value="' + resp[i] + '">' + resp[i] + '</option>');
			}
		}
	})
}

// 처음 map 서울 중심으로 띄우기.	
function initMap() {
	var seoul = { lat: 37.5642135, lng: 127.0016985 };
	var map = new google.maps.Map(document.getElementById('center_map'), {
		zoom: 17,
		center: seoul
	});
}


// 시도 변경시 시군구 가져오기

var sido = document.getElementById('sido');

sido.onchange = function() {
	param = $(frm_center).serialize();
	$('#sigungu').children('option:not(:first)').remove();  // 변경될때 시/군/구 리셋
	$('#dong').children('option:not(:first)').remove();     // 변경될때 읍/면/동 리셋

	$.ajax({
		type: 'post',
		url: "./sigungu.vCenter",
		data: param,
		success: function(resp) {
			var a = resp.trim().split(',');
			for (var i = 0; i < a.length - 1; i++) {
				$('#sigungu').append('<option value="' + a[i] + '">' + a[i] + '</option>');
			}
		}
	})
}


// 시군구 변경시 읍/면/동 가져오기	
var sigungu = document.getElementById('sigungu');

sigungu.onchange = function() {
	param = $(frm_center).serialize();
	$('#dong').children('option:not(:first)').remove();

	$.ajax({
		type: 'post',
		url: "./dong.vCenter",
		data: param,
		success: function(resp) {
			var a = resp.trim().split(',');
			for (var i = 0; i < a.length - 1; i++) {
				$('#dong').append('<option value="' + a[i] + '">' + a[i] + '</option>');
			}
		}
	})
}

// 검색 버튼 클릭시	
var btn_center_search = document.getElementById('btn_center_search');

btn_center_search.onclick = function() {
	var sido = document.getElementById('sido').value;
	param = $(frm_center).serialize();

	if (sido == 'none') {
		alert('시/도를 선택해주세요')
	} else {
		$('#center_div').load('./search.vCenter', param);
	}
}


// 의료기관 div 클릭시 정보 띄우기
function ct_info(num) {
	/*$('#center').on("click",function(){*/

	var rg = document.getElementsByClassName('rg')[num].innerHTML  // 지역정보
	var cn = document.getElementsByClassName('cn')[num].innerHTML  // 병원이름
	var fn = document.getElementsByClassName('fn')[num].innerHTML  // 시설이름
	var date = document.getElementById('date').value  // 시설이름


	var time = document.getElementsByName('time')  // 다른 의료기관 선택시 라디오 체크박스 리셋  
	for (var i = 0; i < time.length; i++) {
		if (time[i].checked == true) {
			time[i].checked = false;
			break;
		}
	}

	var param = 'rg=' + rg + '&centerName=' + cn + '&facilityName=' + fn + '&date=' + date;

	$('#center_information').load('./information.vCenter', param);
}


function infor_init() {

	// 지도에 마커 표시
	var lat = document.getElementById('lat').value
	var lng = document.getElementById('lng').value

	var center = { lat: Number(lat), lng: Number(lng) };

	// 마커표시
	var map = new google.maps.Map(document.getElementById('center_map'), {
		zoom: 15,
		center: center
	});

	var marker = new google.maps.Marker({ position: center, map: map });   // 맵에 마커 표시


	// 시간 체크 후 활성화 여부 확인
	var timeChk = document.getElementsByClassName('timeChk')
	var time = document.getElementsByClassName('tl')

	// 인원수 10명 이상일경우 클릭 이벤트 비활성화
	for (var i = 0; i < timeChk.length; i++) {
		if (timeChk[i].value >= 10) {
			time[i].className = 'time_over_people';
		}
	}

}

var cs = document.getElementById('center_select');


// 예약선택시
cs.onclick = function() {      // 여기서 준화씨한테 보내기전에 인원수 체크한후에 10명 이하면 전송 / 아닐경우 alert 창 띄우기.

	var cn = document.getElementById('center_n').innerHTML;  // 병원이름
	var fn = document.getElementById('center_f').innerHTML;  // 병원이름
	var time = document.getElementsByName('time')
	var date = document.getElementById('date').value;


	for (var i = 0; i < time.length; i++) {    // 체크된 시간선택(라디오) 값 가져오기
		if (time[i].checked == true) {
			var timeval = time[i].value;
			break;
		}
	}

	if (timeval == null || fn == '') {     // 시간 선택 안할시
		alert('병원 및 시간을 선택해주세요')  // 알림 문구
	} else {
		var param = 'centerName=' + cn + '&facilityName=' + fn + '&time=' + timeval + '&date=' + date;

		$.ajax({
			type: 'post',
			url: "timeChk.vCenter",
			data: param,
			success: function(resp) {
				if (resp >= 10) {
					alert("해당 시간에 예약하실수 없습니다.")
				} else {
					self.close();    // 팝업 창 닫기

					opener.document.getElementById('facilityName').value = fn   // 부모창에 값 전달
					opener.document.getElementById('reserveCenter').value = cn
					opener.document.getElementById('reserveDate').value = date
					opener.document.getElementById('reserveTime').value = timeval
				}
			}
		})
	}
}