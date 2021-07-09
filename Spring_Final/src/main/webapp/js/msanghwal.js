/**
 *  생활 방역 게시판 자바 스크립트
 */

var sang = {};
sang.init = function() {

	$('#btnSearch').on('click', function() {
		var frm = $('#frm_sang')[0];
		var param = $(frm).serialize();

		$('#sang').load('../../msanghwal/msanghwal_search.msanghwal', param);
	})

	$('#sang #btnFind').on('click', function() {
		var frm = $('#frm_sang')[0];
		frm.nowPage.value = 1;
		var param = $(frm).serialize();

		$('#sang').load('../../msanghwal/msanghwal_search.msanghwal', param);

	})

	$('#sang #btnInsert').on('click', function() {
		var frm = $('#frm_sang')[0];
		var param = $(frm).serialize();
		$('#sang').load('../../msanghwal/msanghwal_register.msanghwal');
	})
	
	
	$('#sang #btnInsertR').on('click', function(){
		editor_object.getById['sanghwalarea'].exec('UPDATE_CONTENTS_FIELD',[]);
		var frm = $('#frm_upload')[0];
		var data = new FormData(frm);
		
		$.ajax({
			type    : 'POST',
			url     : '../../fup.msanghwal',
			enctype : 'multipart/form-data',
			data    : data,
			contentType : false,
			processData : false,
			success : function(resp){
				frm = $('#frm_sang')[0];
				param = $(frm).serialize();
				$('#sang').load('../../msanghwal/msanghwal_registerR.msanghwal', param);
			},
			error : function(xhr, resp, status){
				alert(resp+ "," + status);
			}
		});
	})
	
	$('#sang #btnUpdate').on('click', function(){
		editor_object.getById['sanghwalarea'].exec('UPDATE_CONTENTS_FIELD',[]);
		var frm = $('#frm_upload')[0];
		var data = new FormData(frm);
		
		$.ajax({
			type    : 'POST',
			url     : '../../fup.msanghwal',
			enctype : 'multipart/form-data',
			data    : data,
			contentType : false,
			processData : false,
			success : function(resp){
				frm = $('#frm_sang')[0];
				frm2 = $('#frm_upload')[0];
				var param1 = $(frm).serialize();
				var param2 = $('.delFile').serialize();
				var param = param1+"&"+param2;
				$.post('../../msanghwal/msanghwal_update.msanghwal', param, function(data){
					$('#sang').html(data);  
				})
			}
		});
	});
	
	$('#sang #btnDelete').on('click', function(){
		var frm = $('#frm_sang')[0];
		var param = $(frm).serialize();
		if (confirm("정말 삭제하시겠습니까??") == true){
			$('#sang').load('../../msanghwal/msanghwal_delete.msanghwal', param)
		}else{
			return;
}
	})
	
};


sang.update = function(serial) {
	var frm = $('#frm_sang')[0];
	frm.serial.value = serial;
	var param = $(frm).serialize();

	$('#sang').load('../../msanghwal/msanghwal_modify.msanghwal', param);
}


sang.move = function(nowPage) {
	var frm = $('#frm_sang')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();

	$('#sang').load('../../msanghwal/msanghwal_search.msanghwal', param);
}

/* 파일 미리보기 --------------------- */
function imageView(fileTag, imageZone) {
	var ft = document.getElementById(fileTag);
	var izone = document.getElementById(imageZone);

	ft.onchange = function(ev) {
		var ele = ev.srcElement;//이벤트가 발생한 테그
		var files = ele.files;
		for (var index in files) {
			console.table(files[index]);
		}

		for (var file of files) {
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(ev2) {
				var div = makeItem(izone);
				var img = new Image();
				img.src = ev2.target.result;

				div.appendChild(img);
				izone.appendChild(div);
			}
		}

	} // end of ft.onchage

	// drag & drop 기능 추가
	izone.ondragenter = function(e) {
		e.preventDefault();
		e.stopPropagation();
		return false;
	}

	izone.ondragover = function(e) {
		e.preventDefault();
		e.stopPropagation();
		return false;
	}

	izone.ondrop = function(e) {
		e.preventDefault();
		e.stopPropagation();

		var dt = e.dataTransfer;
		var files = dt.files;

		for (var file of files) {
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(ev2) {
				var div = makeItem(izone);
				var img = new Image();
				img.src = ev2.target.result;

				div.appendChild(img);
				izone.appendChild(div);
			}
		}
	}
}


function makeItem(izone) {
	// div 태그 생성 : <div class='item'></div>
	var div = document.createElement('div');
	div.setAttribute('class', 'item');

	// 삭제버튼 : <input type='button' value='x' class='del_btn' name='btnDel+ N'/>
	var delBtn = document.createElement('input');
	delBtn.setAttribute('type', 'button');
	delBtn.setAttribute('value', 'X')
	delBtn.setAttribute('class', 'del_btn')
	delBtn.setAttribute('name', 'btnDel')

	div.appendChild(delBtn);

	delBtn.onclick = function() {
		var p = this.parentNode;
		izone.removeChild(p);
	}


	return div;
}





