/**
 * 
 */
$(document).ready(function(){
	$('.case #city0').addClass('open');
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