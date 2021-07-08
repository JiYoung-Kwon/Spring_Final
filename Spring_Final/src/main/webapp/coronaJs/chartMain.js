/**
 * 
 */
$(document).ready(function(){
	$('.case #city0').addClass('open');
	
	$("#select0").attr("onclick", "$('#middle').load('/Spring_Final/corona/searchK.corona')");
	$("#select1").attr("href", "http://www.seoul.go.kr/coronaV/coronaStatus.do");
	$("#select2").attr("href", "http://www.busan.go.kr/corona19/index");
	$("#select3").attr("href", "http://www.daegu.go.kr/");
	$("#select4").attr("href", "https://www.incheon.go.kr/");
	$("#select5").attr("href", "https://www.gwangju.go.kr/");
	$("#select6").attr("href", "https://www.daejeon.go.kr/corona19/index.do");
	$("#select7").attr("href", "http://www.ulsan.go.kr/corona.jsp");
	$("#select8").attr("href", "https://www.sejong.go.kr/life/sub05_0704.do");
	$("#select9").attr("href", "https://www.gg.go.kr/bbs/boardView.do?bsIdx=464&bIdx=2296956&menuId=1535");
	$("#select10").attr("href", "http://www.provin.gangwon.kr/");
	$("#select11").attr("href", "http://www.chungbuk.go.kr/");
	$("#select12").attr("href", "http://www.chungnam.go.kr/coronaStatus.do");
	$("#select13").attr("href", "http://www.jeonbuk.go.kr/");
	$("#select14").attr("href", "https://www.jeonnam.go.kr/coronaMainPage.do");
	$("#select15").attr("href", "http://gb.go.kr/corona_main.htm");
	$("#select16").attr("href", "http://www.gyeongnam.go.kr/corona.html");
	$("#select17").attr("href", "https://jeju.go.kr/covid19.jsp");
	$("#select18").attr("onclick", "$('#middle').load('/Spring_Final/corona/searchG.corona')");

})

function CityChart(){
	var region = $('.map .map_graph #map_layout svg path');
	var btn = $('.map .map_graph #map_layout button');
	
	btn.click(function(){
        var thDataCity = $(this).attr('data-city');
        btn.removeClass('select');
        $(this).addClass('select');
		$('.case>*').removeClass('open');
        $('.case>#' + thDataCity).addClass('open');
        return false;
    });

	region.click(function(){
       	var thDataCity = $(this).attr('class');
        btn.removeClass('select');
        $('.map .map_graph #map_layout button[data-city="' + thDataCity + '"]').addClass('select');
        $('.case>*').removeClass('open');
        $('.case>#' + thDataCity).addClass('open');
    });
}