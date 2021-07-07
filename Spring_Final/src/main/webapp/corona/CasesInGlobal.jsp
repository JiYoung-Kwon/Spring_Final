<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale = 1.0' />
<title>국외 발생 현황</title>

<style>

/* css- 확진자 성별 현황 , 연령별 현황*/
#table6 *, #table7 *, #table8 * {
	box-sizing: border-box;
	vertical-align: middle;
	text-align: center;
}

#table6, #table7, #table8 {
	display: table;
	width: 1250px;
	border-spacing: 0;
	margin: 0px;
	padding: 0px;
}

#table6 .tr, #table7 .tr, #table8 .tr {
	display: table-row;
	height: 30px;
}

#table6 .td, #table7 .td, #table8 .td {
	display: table-cell;
	border: 1px solid #00000020;
}

#table6 .td:first-child {
	width: 698px;
	border-right: 0px;
	border-top: 2px solid #13669b;
	border-bottom: 1px solid #6d88b7;
	background: #f0fdff;
}

#table6 .td:last-child {
	width: 550px;
	border-top: 2px solid #13669b;
	border-bottom: 1px solid #6d88b7;
	background: #f0fdff;
}

#table7>.tr>.td {
	width: 300px;
	border-top: 0px;
}

#table7>.tr>.tr>.td:first-child {
	width: 400px;
	border-top: 0px;
	border-left: 0px;
}

#table7>.tr>.tr>.td:last-child {
	width: 550px;
	border-top: 0px;
	border-left: 0px;
}

#table8>.tr>.td {
	width: 700px;
	border-top: 0px;
	border-bottom: 1px solid #6d88b7;
}

#table8>.tr>.tr>.td {
	width: 550px;
	border-top: 0px;
	border-left: 0px;
	border-bottom: 1px solid #6d88b7;
}

#cases{
	width: max-content;
    margin: 0 auto;
}

h2::before {
	display: inline-block;
	content: '';
	width: 10px;
	height: 20px;
	margin-left: -20px;
	margin-right: 7px;
	background-color: #13669B;
	border-right: 4px solid #0b9bc9;
}

h3::before {
	display: inline-block;
	content: '';
	width: 8px;
	height: 8px;
	margin-left: -16px;
	margin-right: 8px;
	border: 3px solid #0b9bc9;
}

</style>

</head>

<body>
	<div id='cases'>
		<h2>국외 발생 현황</h2>
		코로나바이러스감염증-19 국외 발생현황
		<div id='global'>
			<c:set var='stdDay' value='${gList[0].stdDay }' />
			<h3> 전체 국가 발생 현황
				(${fn:substring(stdDay,0,4)}.${fn:substring(stdDay,4,6)}.${fn:substring(stdDay,6,8)}
				${gList[0].stdTime} 기준)</h3>
			<div id='table6'>
				<div class='tr'>
					<div class='td'>지역 및 국가</div>
					<div class='td'>환자발생 수 (사망)</div>
				</div>
			</div>

			<div id='table7'>
				<div class='tr'>
					<div class='td'>아시아</div>
					<c:set var="nowNum" value="28"></c:set>
					<c:forEach var="i" begin="0" end="${nowNum}" step="1">
   						<div class='tr'>
						<div class='td'>${gList[188 - i].nationNm }</div>
							<div class='td'>
							<fmt:formatNumber
								value="${gList[188 - i].natDefCnt}" pattern="#,###" />명 (사망 <fmt:formatNumber
								value="${gList[188 - i].natDeathCnt}" pattern="#,###" />)</div>
						</div>			
					</c:forEach>
				</div>

				<div class='tr'>
					<div class='td'>중동</div>
					<c:set var="nowNum" value="17"></c:set>
					<c:forEach var="i" begin="0" end="${nowNum}" step="1">
   						<div class='tr'>
						<div class='td'>${gList[159 - i].nationNm }</div>
							<div class='td'>
							<fmt:formatNumber
								value="${gList[159 - i].natDefCnt}" pattern="#,###" />명 (사망 <fmt:formatNumber
								value="${gList[159 - i].natDeathCnt}" pattern="#,###" />)</div>
						</div>			
					</c:forEach>
				</div>

				<div class='tr'>
					<div class='td'>아메리카</div>
					<c:set var="nowNum" value="34"></c:set>
					<c:forEach var="i" begin="0" end="${nowNum}" step="1">
   						<div class='tr'>
						<div class='td'>${gList[141 - i].nationNm }</div>
							<div class='td'>
							<fmt:formatNumber
								value="${gList[141 - i].natDefCnt}" pattern="#,###" />명 (사망 <fmt:formatNumber
								value="${gList[141 - i].natDeathCnt}" pattern="#,###" />)</div>
						</div>			
					</c:forEach>
				</div>

				<div class='tr'>
					<div class='td'>유럽</div>
					<c:set var="nowNum" value="48"></c:set>
					<c:forEach var="i" begin="0" end="${nowNum}" step="1">
   						<div class='tr'>
						<div class='td'>${gList[106 - i].nationNm }</div>
							<div class='td'>
							<fmt:formatNumber
								value="${gList[106 - i].natDefCnt}" pattern="#,###" />명 (사망 <fmt:formatNumber
								value="${gList[106 - i].natDeathCnt}" pattern="#,###" />)</div>
						</div>			
					</c:forEach>
				</div>
				
				<div class='tr'>
					<div class='td'>오세아니아</div>
					<c:set var="nowNum" value="7"></c:set>
					<c:forEach var="i" begin="0" end="${nowNum}" step="1">
   						<div class='tr'>
						<div class='td'>${gList[57 - i].nationNm }</div>
							<div class='td'>
							<fmt:formatNumber
								value="${gList[57 - i].natDefCnt}" pattern="#,###" />명 (사망 <fmt:formatNumber
								value="${gList[57 - i].natDeathCnt}" pattern="#,###" />)</div>
						</div>			
					</c:forEach>
				</div>
				
				<div class='tr'>
					<div class='td'>아프리카</div>
					<c:set var="nowNum" value="48"></c:set>
					<c:forEach var="i" begin="0" end="${nowNum}" step="1">
   						<div class='tr'>
						<div class='td'>${gList[49 - i].nationNm }</div>
							<div class='td'>
							<fmt:formatNumber
								value="${gList[49 - i].natDefCnt}" pattern="#,###" />명 (사망 <fmt:formatNumber
								value="${gList[49 - i].natDeathCnt}" pattern="#,###" />)</div>
						</div>			
					</c:forEach>
				</div>
				
				<div class='tr'>
					<div class='td'>기타</div>
   						<div class='tr'>
						<div class='td'>${gList[0].nationNm }</div>
							<div class='td'>
							<fmt:formatNumber
								value="${gList[0].natDefCnt}" pattern="#,###" />명 (사망 <fmt:formatNumber
								value="${gList[0].natDeathCnt}" pattern="#,###" />)</div>
						</div>
				</div>
			</div>
			
			<div id = 'table8'>
				<div class='tr'>
					<div class='td' id = 'total'>합계</div>
   						<div class='tr'>
							<div class='td'>
							<fmt:formatNumber
								value="${total['TOTALDEF']}" pattern="#,###" />명 (사망 <fmt:formatNumber
								value="${total['TOTALDEATH']}" pattern="#,###" />)</div>
						</div>
				</div>
			</div>
		</div>


		<br /> <br />
	</div>

</body>

</html>