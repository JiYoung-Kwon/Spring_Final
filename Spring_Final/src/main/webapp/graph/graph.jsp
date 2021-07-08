<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>graph</title>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script> -->


<link rel='StyleSheet' type='text/css'
	href='./graph/formtest.css'>
<script  src="./graph/graph.js"></script>
</head>

<body>
	<div id='graph'>
		<h2>시도별 접종 현황</h2>
		코로나바이러스감염증-19 시도별 접종 현황

		<div id='stable'>
			<div>
				<label>마지막 업데이트 : ${Ddate}</label>
			</div>
			<table id="sta">
				<thead>
					<tr>
						<th scope="cols">구분</th>
						<th scope="cols">1회차 접종</th>
						<th scope="cols">2회차 접종</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${koDataVo}" var='vo'>
						<tr>
							<td>당일누적 A+B
							</th>
							<td>${vo.oneday}
							</th>
							<td>${vo.twoday}
							</th>
						</tr>
						<tr>
							<td>전일실적 A
							</th>
							<td>${vo.oneplu}
							</th>
							<td>${vo.twoplu}
							</th>
						</tr>
						<tr>
							<td>전일누적 B
							</th>
							<td>${vo.onesum}
							</th>
							<td>${vo.twosum}
							</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<div class="tab_basic">
			<div class="tab_list_wrap">
				<div class="tab_list tab_active" data-tabnum="0">
					<a href="#">1회차 접종</a>
				</div>
				<div class="tab_list" data-tabnum="1">
					<a href="#">2회차 접종</a>
				</div>
				<div class="tab_list" data-tabnum="2">
					<a href="#">자세히보기</a>
				</div>
			</div>
			<div class="tab_container">
				<div class="tab_content"><canvas id="logChart" ></canvas></div>
				<div class="tab_content"><canvas id="Chart"></canvas></div>
				<div class="tab_content"><div id='btable' style="position: relative;">
					<h2>시도별 접종 현황</h2>

					<table id='bta'>

						<colgroup>
							<col style="width: 14%;">
							<col style="width: 21.5%;">
							<col style="width: 21.5%;">
							<col style="width: 21.5%;">
							<col style="width: 21.5%;">
						</colgroup>

						<thead>
							<tr>
								<th scope="col" rowspan="2">구분</th>
								<th scope="col" colspan="2">1회차접종</th>
								<th scope="col" colspan="2">2회차접종</th>
							</tr>
							<tr>
								<th scope="col">전일실적</th>
								<th scope="col">당일누계</th>
								<th scope="col">전일실적</th>
								<th scope="col">당일누계</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${CityDataVo}" var='vo'>
								<tr id="top">
									<td scope="row">${vo.num}</td>
									<td>${vo.oneplu}</td>
									<td>${vo.onesum}</td>
									<td>${vo.twoplu}</td>
									<td>${vo.twosum}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id = "update" >마지막 업데이트 : ${Ddate1}</div>
				</div></div>
			</div>
		</div>
	</div>

	<script>
	graph.tab();
	graph.graph(${one}, ${ two }, ${ thr }, ${ fou }, ${ fix }, ${ six }, ${ ser }, ${ eig }, ${ nin }, ${ ten }, ${ ele }, ${ twe }, ${ thi }, ${ fon }, ${ fif }, ${ sin }, ${ sev }, ${ gin });
	graph.kp(${oneone},${onetwo},${onethr},${onefou},${onefix},${onesix},${oneser},${oneeig},${onenin},${oneten},${oneele},${onetwe},${onethi},${onefon},${onefif},${onesin},${onesev},${onegin})
	</script>

</body>

</html>