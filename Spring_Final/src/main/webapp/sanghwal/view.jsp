<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>생활 방역 게시판 조회</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='./js/sanghwal.js'></script>

<link rel='StyleSheet' type='text/css' href='./css/sang.css'>
<body>
<div id='sang'>
<form name='frm_sang' id='frm_sang' method='post' action=''>
 <div id='head'>
   <label id='title'><h1>${vo.title }</h1></label>
   <hr/>
   <label id='mdate'>${vo.mdate }</label>
   <hr/>
   <label id='mid'>${vo.mId }</label>
   <span id = 'hit'>조회수 : ${vo.hit }</span>
 </div>
 <div id='center'>
  <div id='image_zone'>
			<c:forEach var='f' items="${vo2.attList}">
				<a href='../upload/${f.sysAtt }' download='${f.oriAtt }' >
					<img src="../upload/${f.sysAtt }"/>
				</a>
			</c:forEach>
		</div>
  
  <div id = 'doc'>
    ${vo.doc }
  </div>
 </div>
 
 <div id='vbtn_zone'>
   <input type='button' id='btnSearch' value='닫기'/>
 </div>
 
 <input type='hidden' name='nowPage' value='${param.nowPage }'/>		
 <input type='hidden' name='findStr' value='${param.findStr }'/>		
 <input type='hidden' name='serial' value='${param.serial }'/>
 
</form>
</div>
<script>
sang.init();
</script>
</body>
</html>