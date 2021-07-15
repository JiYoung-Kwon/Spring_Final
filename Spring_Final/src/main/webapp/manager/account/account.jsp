<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
#account_reader_wrapper{
	width: 1100px;
	height: max-content;
}
#frm_wrapper{
	margin : 0 auto;
	width: 800px;
	height: max-content;
}
#account_header_frm{
    margin: 25px 0;
    font-weight: bold;
    font-size: 30px;
}
#account_board_frm{
	width: 800px;
	height: max-content;
	text-align: center;
	font-size: 20px;
    line-height: 2;
    border-bottom: 0.5px solid;
}
#account_board_frm>#account_item{
	display: flex;
	height: 40px;
	font-weight: bold;
	background-color: #eaeaea;
} 
#account_board_frm>#account_item>div{
	flex:1;
	border: 0.5px solid black;
	border-bottom: 0px;
}
#account_board_frm>#account_item>div:nth-child(4), #account_board_frm>.account_items>div:nth-child(4){
	flex:1.5;
}
#account_board_frm>#account_item>div:nth-child(5), #account_board_frm>.account_items>div:nth-child(5){
	flex:1.5;
}
#account_board_frm>.account_items{
	display: flex;
	height: 40px;
	cursor: pointer;
}
#account_board_frm>.account_items>div{
	flex:1;
	border: 0.5px solid black;
	border-bottom: 0px;
}
#btn_insert{
    float: right;
    margin-top: 15px;
    position: relative;
    width: 100px;
    height: 35px;
    top: 0px;
    left: -20px;
    font-size: 15px;
    font-weight: 700;
    border: 0px;
}
#unotice_footer_frm{
	display:flex;
    margin: 50px auto;
    width: max-content;
}
#unotice_footer_frm input[type=button]{
    width: 40px;
    height: 40px;
}
#unotice_center{
	min-width: max-content;
    margin: 0px 15px;
}
#unotice_center input[type=button]{
	margin: 0 3px;
	width: 40px;
    height: 40px;
}
#unotice_previous , #unotice_next{
	width: 86px;
}
.now_btn{
	background-color: #3498db;
	color: #ffffff;
	border: 0px;
	cursor: pointer;
}
.page_button{
    background-color: #f4f4f4;
    cursor: pointer;
    border: 1px solid #e8dfdf;
}
.page_button:hover {
	background-color: #aba9a9;
}

</style>
</head>
<body>
	<div id="account_reader_wrapper">
		
		
	<div id= "frm_wrapper">
		<div id="account_header_frm">관리자 계정 데이터 관리</div>
		<form id="account_board_frm" name="account_board_frm" method="post" action="">
			<div id="account_item">
				<div>ID</div>
				<div>NAME</div>
				<div>계정 생성일</div>
				<div>업무명</div>
				<div>직무명</div>
			</div>
			<c:forEach var="vo" items="${list}" varStatus="index">
				<div class="account_items" onclick="accountView(${index.index})">
					<div>${vo.mid}</div>
					<div>${vo.mname}</div>
					<div>${vo.mdate}</div>
					<div>${vo.mjob}</div>
					<div>${vo.mposition}</div>
				</div>
			</c:forEach>
		<input id="nowPage" name="nowPage" type="hidden" value="${(empty page.nowPage) ? 1 : page.nowPage}">
		<input id="findStr" name="findStr" type="hidden" value="${page.findStr}">
		</form>
		<input id="btn_insert" type="button" value="계정 생성" onclick="registerPageMove()"> 
		
		<div id="unotice_footer_frm">
			<div id="unotice_previous">   
				<c:if test="${page.nowPage>1}">					     <!-- 이전 / 첫 페이지  -->
				<input type="button" class="page_button" onclick="accountPageMove(1)" value="<<">
				<input type="button" class="page_button" onclick="accountPageMove(${page.nowPage - 1})" value="<">
				</c:if>
			</div>
			
			<div id="unotice_center">
				<c:forEach var="p" begin="${page.startPage}" end="${page.endPage}">   <!-- 버튼 갯수  -->
				<input type="button" class="page_button" value="${p}" onclick="accountPageMove(${p})" >
				</c:forEach>
			</div>
			
			<div id="unotice_next">
				<c:if test="${page.nowPage<page.totPage}">				<!-- 다음 / 마지막 페이지  -->
				<input type="button" class="page_button" onclick="accountPageMove(${page.nowPage + 1})" value=">">
				<input type="button" class="page_button" onclick="accountPageMove(${page.totPage})" value=">>">
				</c:if>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript" src="../account/account.js"></script>
	<script type="text/javascript">initAccount()</script>
	<script type="text/javascript">init()</script>
</body>
</html>