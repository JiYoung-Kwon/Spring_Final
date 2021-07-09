<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>search</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src='/Spring_Final/mapJs/map.js'></script>
</head>
<body>

<div class='none'></div>

<c:forEach items="${list}" var="vo" varStatus="index">
<div class='find_list'>
	<ul id="load_list">
		<li>
			<span class='pointer'>${index.index+1}</span>
				<dl>
					<dt>
						<span id='submit' class="submit" onclick="gotohome(${index.index})">${vo.hospitalName}</span>
					</dt>
					<dd id='addr' class='addr'>${vo.address}</dd>
					<dd class='telno'>📞 ${vo.phoneNumber}</dd>
					<dd class='hospurl'>${vo.hospUrl}</dd>
					<dd class='hosptype'>${vo.hospType}</dd>
				</dl>
		</li>
	</ul>
	
	
</div>


</c:forEach>	
								

</body>
</html>


	<%-- <input type='hidden' class='hospurl' value=${vo.hospUrl } />
	<input type='hidden' class='hosptype' value=${vo.hospType } /> --%>
<%-- <a href="javacript:pointerOnClick('${index.index }')">${vo.hospitalName}</a> --%>