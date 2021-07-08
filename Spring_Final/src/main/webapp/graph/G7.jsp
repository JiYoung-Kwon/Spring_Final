<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel='StyleSheet' type='text/css' href='./graph/formtest.css'>
<script src="./graph/graph.js"></script>
</head>
<body>
	<div id="graph">
		<h2>국외 접종 현황</h2>
		코로나바이러스감염증-19 국외 접종 현황
		<div style="margin-top: 30px; margin-bottom: 30px;">
			<iframe
				src="https://ourworldindata.org/grapher/covid-vaccination-doses-per-capita?tab=table&amp;time=earliest..2021-05-20&amp;country=GBR~USA~ARG~AUS~BRA~CAN~CHN~FRA~DEU~IND~IDN~ITA~JPN~KOR~MEX~RUS~SAU~ZAF~TUR~European+Union"
				loading="lazy"
				style="width: 1250px; height: 600px; border: 0px none;"}"></iframe>
		</div>
		<h2>G7 & 지구촌 & 한국</h2>
		<h3>
			100명당 접종된 백신수
			</h6>
			<canvas id="logChart"></canvas>

			<div id="update">${Ddate}</div>
	</div>

	<script>
	graph.G7(${United},${America},${Canada},${Germany},${Italy},${Japan},${England},${one},${ko});

</script>




</body>
</html>