/**
 * 
 */
var videoId;

getJson = function(yJson) {
	videoId = yJson;
}
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
//플레이어 변수 설정
var player;
function onYouTubeIframeAPIReady() {
	for (var i = 0; i < videoId.length; i++) {
		player = new YT.Player('player' + i, {
			width: '380',
			height: '225',
			videoId: videoId[i]
		});
	}

}