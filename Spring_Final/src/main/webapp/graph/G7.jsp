<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='../js/graph.js'></script>
<link rel='StyleSheet' type='text/css' href='/coronaMain/graph/formtest.css'>
</head>
<body>
	<div id="graph" >
		
		<div>
			<iframe
				src="https://ourworldindata.org/grapher/covid-vaccination-doses-per-capita?tab=table&amp;time=earliest..2021-05-20&amp;country=GBR~USA~ARG~AUS~BRA~CAN~CHN~FRA~DEU~IND~IDN~ITA~JPN~KOR~MEX~RUS~SAU~ZAF~TUR~European+Union"
				loading="lazy"
				style="width: 1400px; height: 600px; border: 0px none;"}"></iframe>
		</div>
		<h1>G7 & 지구촌 & 한국</h1>
			<h3>100명당 접종된 백신수</h6>
		<canvas id="logChart"></canvas>

		<div id = "update">${Ddate}</div>
	</div>
	
	<script>
	graph.G7(${United},${America},${Canada},${Germany},${Italy},${Japan},${England},${one},${ko});

</script>




</body>
</html>