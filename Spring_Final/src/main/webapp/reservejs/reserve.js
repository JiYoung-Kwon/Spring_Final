/**
 * 백신 예약 스크립트
 */

var reserve = {};
var checkNumber;
var toPhone;
var tomail;

function button_a(){   // 의료기관찾기 버튼 클릭시 윈도우 창으로 띄우기
	window.open('./vCenter/vCenter.jsp','win','width=517px,height=815px');
}

reserve.init = function(){
	
	//문자전송	
	$('#reserve #btnSmsSend').on('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();

		$.ajax({
			type    : 'POST',
			url     : '../smsSender.reserve',
			data    : param,
			dataType : "json",
			success : function(resp) {
				alert('문자가 전송되었습니다.');
				
				checkNumber = resp.chkNum;
				toPhone = resp.toPhone;

			},
			error : function(resp){
				alert('문자 전송을 실패했습니다.');
			}
		});
	})
	
	//메일전송
	$('#reserve #btnMailSend').unbind("click").bind('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();

		$.ajax({
			type    : 'POST',
			url     : '../mailSender.reserve',
			data    : param,
			dataType : "json",
			success : function(resp) {
				alert('메일이 전송되었습니다.');
				
				checkNumber = resp.chkNum;
				tomail = resp.tomail;
				
			},
			error : function(resp){
				alert('메일 전송을 실패했습니다.');
			}
		});
	})
	
	$('#reserve #btnChkNum').on('click', function(){
		
		var key = document.getElementById("key").value;
		
		if(key == checkNumber){
			alert('인증되었습니다.')
			self.close();
			opener.document.getElementById("Email").value = document.getElementById("tomail").value;
			opener.document.getElementById("reserveOk").value = "인증되었습니다";
			$("#Email",opener.document).prop("readonly",true);
			
		}else(
			alert('인증번호를 다시 확인해 주세요.')
		)
	})
	
	$('#reserve #btnSmsChkNum').on('click', function(){
		
		var key = document.getElementById("key").value;
		
		if(key == checkNumber){
			alert('인증되었습니다.')
			self.close();
			opener.document.getElementById("reservePhone").value = document.getElementById("reservePhone").value;
			opener.document.getElementById("reserveOk").value = "인증되었습니다";
			$("#reservePhone",opener.document).prop("readonly",true);
			
		}else(
			alert('인증번호를 다시 확인해 주세요.')
		)
	})

	$('#reserve #btnReserve').unbind("click").bind("click", function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		if($('#myName').val() == ''){
			alert('접종 대상자 이름을 입력하세요.');
			return;
		}else if($('#myJumin').val() == ''){
			alert('접종 대상자 주민번호를 입력하세요');
			return;
		}else if($('#reserveVaccine').val() == ''){
			alert('접종하실 백신을 입력하세요');
			return;
		}else if($('#myPhone').val() == ''){
			alert('접종 대상자 휴대폰 번호를 입력하세요');
			return;
		}else if($('#Email').val() == ''){
			alert('이메일을 입력하세요');
			return;
		}else if($('#reserveCenter').val() == ''){
			alert('예약 병원 및 접종 시간을 입력하세요');
			return;
		}else{
			if(document.getElementById("reserveOk").value != "인증되었습니다"){
				alert('인증을 완료하여 주세요.')
			}else{
				$.ajax({
					type    : 'POST',
					url     : './timeChk.reserve',
					data    : param,
					success : function(resp){
						if (resp >= 10) {
							alert("해당 시간에 예약하실수 없습니다. 시간을 다시 선택해 주세요.")
						} else {
							$.ajax({
								type    : 'POST',
								url     : './insert.reserve',
								data    : param,
								success : function(resp){
									
									$.post('./infoMailSender.reserve', param, function(){
										alert('예약정보를 메일로 전송했습니다.');
									})
									
									alert('예약이 완료되었습니다. 조회화면으로 넘어갑니다.');
									$('#middle').load('./sc.reserve');	
								}
							});	
						}
					}
				});	
			}
		}
	})
	
	$('#reserve #btnReserveOther').unbind("click").bind("click", function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		var frm2 = $('#frm_otherReserve')[0];
		var phone = document.getElementById("myPhone").value;

		var param2 = $(frm2).serialize();
		var param3 = param2+"&myPhone="+phone
		
		if($('#otherName').val() == ''){
			alert('대리예약자 이름을 입력하세요.');
			return;
		}else if($('#otherJumin').val() == ''){
			alert('대리예약자 주민번호를 입력하세요');
			return;
		}else if($('#otherPhone').val() == ''){
			alert('대리예약자 휴대폰 번호를 입력하세요');
			return;
		}else if($('#myName').val() == ''){
			alert('접종 대상자 이름을 입력하세요');
			return;
		}else if($('#myPhone').val() == ''){
			alert('접종 대상자 휴대폰 번호를 입력하세요');
			return;
		}else if($('#myJumin').val() == ''){
			alert('접종 대상자 주민번호를 입력하세요');
			return;
		}else if($('#reserveVaccine').val() == ''){
			alert('접종하실 백신을 입력하세요');
			return;
		}else if($('#Email').val() == ''){
			alert('이메일을 입력하세요');
			return;
		}else if($('#reserveCenter').val() == ''){
			alert('예약 병원 및 접종 시간을 입력하세요');
			return;
		}else{
			if(document.getElementById("reserveOk").value != "인증되었습니다"){
				alert('인증을 완료하여 주세요.')
			}else{
				$.ajax({
					type    : 'POST',
					url     : './timeChk.reserve',
					data    : param,
					success : function(resp){
						if (resp >= 10) {
							alert("해당 시간에 예약하실수 없습니다. 시간을 다시 선택해 주세요.")
						} else {
							$.ajax({
								type    : 'POST',
								url     : './insert.reserve',
								data    : param,
								success : function(resp){
									
									$.post('./infoMailSender.reserve', param, function(){
										alert('예약정보를 메일로 전송했습니다.');
									})
									
									$.post('./otherInsert.reserve', param3, function(data){
									$('#middle').html(data);
															
									alert('예약이 완료되었습니다. 조회화면으로 넘어갑니다.');
									})
								}
							});
						}
					}
			});
		}
		}
	})
	
	$('#reserve #btnSearch').on('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		if(document.getElementById("myName").value == "" || document.getElementById("reservePhone").value == "" || document.getElementById("reserveNum").value == ""){
			alert('예약정보를 모두 입력해 주세요.')
		
		}else{
			$.ajax({
				type    : 'POST',
				url     : './search.reserve',
				data    : param,
				success : function(resp){
					if(resp.phone == null){
						alert('조회 화면으로 이동합니다.');
						$('#middle').load('./search.reserve', param);
					}
				},
				
				error : function(xhr, resp, status){
				alert('입력하신 정보를 조회 할 수 없습니다.');
				}
			});

		}

	})
	
	$('#reserve #btnFind').on('click', function(){
		$('#middle').load('./find.reserve');		
	})
	
	$('#reserve #btnFindR').on('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		if(document.getElementById("myName").value == "" || document.getElementById("myJumin").value == "" || document.getElementById("reservePhone").value == ""){
			alert('접종받는 분 정보를 모두 입력해 주세요.')
		}else{
			$.ajax({
				type    : 'POST',
				url     : './findNum.reserve',
				data    : param,
				dataType : "json",
				success : function(resp){
						alert('예약 번호는 : ' + resp.reserveNum + ' 입니다.');
				},
				error : function(xhr, resp, status){
				alert('입력하신 정보를 조회 할 수 없습니다.');
				}
			});
		}
	})

	$('#reserve #btnCancle').on('click', function(){
		$('#middle').load('./canclePage.reserve');		
	})
	
	$('#reserve #btnCancleR').on('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		$.ajax({
				type    : 'POST',
				url     : './cancle.reserve',
				data    : param,
				success : function(resp){
						alert('예약이 취소되었습니다. 조회 화면으로 이동합니다.');
						$('#middle').load('./sc.reserve');
				},
				
				error : function(xhr, resp, status){
				alert('입력하신 정보를 삭제 할 수 없습니다.');
				}
			});
	})
	
}

reserve.mykeyup = function(){
	//데이터입력 양식
		var autoHypenPhone = function(str){
	      str = str.replace(/[^0-9]/g, '');
	      var tmp = '';
	      if( str.length < 4){
	          return str;
	      }else if(str.length < 7){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3);
	          return tmp;
	      }else if(str.length < 11){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 3);
	          tmp += '-';
	          tmp += str.substr(6);
	          return tmp;
	      }else{              
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 4);
	          tmp += '-';
	          tmp += str.substr(7);
	          return tmp;
	      }
	      return str;
	}
	
		var autoHypenJumin = function(str){
	      str = str.replace(/[^0-9]/g, '');
	      var tmp = '';
	      if( str.length < 15){
	          tmp += str.substr(0, 6);
	          tmp += '-';
	          tmp += str.substr(6);
	          return tmp;
	      }
	      return str;
	}
	
	var phoneNum = document.getElementById('reservePhone');
	
	phoneNum.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenPhone( this.value ) ;  
	}
	
	var jumin = document.getElementById('myJumin');
	
	jumin.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenJumin( this.value ) ;  
	}
}

reserve.otherkeyup = function(){
	//데이터입력 양식
		var autoHypenPhone = function(str){
	      str = str.replace(/[^0-9]/g, '');
	      var tmp = '';
	      if( str.length < 4){
	          return str;
	      }else if(str.length < 7){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3);
	          return tmp;
	      }else if(str.length < 11){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 3);
	          tmp += '-';
	          tmp += str.substr(6);
	          return tmp;
	      }else{              
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 4);
	          tmp += '-';
	          tmp += str.substr(7);
	          return tmp;
	      }
	      return str;
	}
	
		var autoHypenJumin = function(str){
	      str = str.replace(/[^0-9]/g, '');
	      var tmp = '';
	      if( str.length < 15){
	          tmp += str.substr(0, 6);
	          tmp += '-';
	          tmp += str.substr(6);
	          return tmp;
	      }
	      return str;
	}
	
	var phoneNum = document.getElementById('myPhone');

	phoneNum.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenPhone( this.value ) ;  

	}

	var phoneNum2 = document.getElementById('reservePhone');

	phoneNum2.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenPhone( this.value ) ;  
	}

	var jumin = document.getElementById('myJumin');

	jumin.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenJumin( this.value ) ;  
	}
	
	var jumin2 = document.getElementById('otherJumin');
	
	jumin2.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenJumin( this.value ) ;  
	}
}

reserve.mykeyupchk = function(){
	//데이터입력 양식
		var autoHypenPhone = function(str){
	      str = str.replace(/[^0-9]/g, '');
	      var tmp = '';
	      if( str.length < 4){
	          return str;
	      }else if(str.length < 7){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3);
	          return tmp;
	      }else if(str.length < 11){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 3);
	          tmp += '-';
	          tmp += str.substr(6);
	          return tmp;
	      }else{              
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 4);
	          tmp += '-';
	          tmp += str.substr(7);
	          return tmp;
	      }
	      return str;
	}

	var phoneNum = document.getElementById('reservePhone');
	
	phoneNum.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenPhone( this.value ) ;  
	}

}

function initMap()	{
    var seoul = {lat: 37.5642135 ,lng: 127.0016985 };       
    var map = new google.maps.Map(document.getElementById('center_map'), {
        zoom: 17,
	      center: seoul
      });
}	
	
