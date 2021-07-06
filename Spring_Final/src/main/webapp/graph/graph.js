/**
 * 
 */

var graph = {};

var plugin = {
   afterDatasetsDraw: function(chart) {
      var ctx = chart.ctx;
      chart.data.datasets.forEach(function(dataset, i) {
         var meta = chart.getDatasetMeta(i);
         if (!meta.hidden && i == 0) {
            meta.data.forEach(function(element, index) {
               // Draw the text in black, with the specified font
               ctx.fillStyle = 'rgb(0, 0, 0)';
               var fontSize = 15;
               var fontStyle = 'normal';
               var fontFamily = 'Helvetica Neue';
               ctx.font = Chart.helpers.fontString(fontSize, fontStyle, fontFamily);
               // Just naively convert to string for now
               var dataString = dataset.data[index].toString();
               // Make sure alignment settings are correct
               ctx.textAlign = 'center';
               ctx.textBaseline = 'middle';
               var padding = 25;
               var position = element.tooltipPosition();
               ctx.fillText(dataString, position.x + (fontSize / 2) + padding, position.y);
            });
         }
      });
   }
};





graph.graph = function(one, two, thr, fou, fix, six, ser, eig, nin, ten, ele, tew, thi, fon, fif, sin, sev, gin) {
   $(function() {
      var ctx = document.getElementById("logChart").getContext('2d');//1차
      var myChart = new Chart(ctx, {
         type: 'horizontalBar',
         data: {
            labels: ["전국", "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주"],
            datasets: [{

               label: "1차 지역별 백신 백분율",
               data: [one, two, thr, fou, fix, six, ser, eig, nin, ten, ele, tew, thi, fon, fif, sin, sev, gin], //컨트롤러에서 모델로 받아온다.

               backgroundColor:
                  'rgba(255, 99, 132, 7)',
               borderColor:
                  'rgba(80, 188, 233, 0.2)'
               ,
               borderWidth: 1
            }
            ]
         },
         options: {
            legend: {
               display: false
            },
            scales: {
               xAxes: [{
                  ticks: {
                     max: one*3/2
                  }
               }],
               yAxes: [{
                  ticks: {
	
                  }
               }]
            }

         },
         plugins: plugin
      });
   })
};

graph.kp = function(oneone, onetwo, onethr, onefou, onefix, onesix, oneser, oneeig, onenin, oneten, oneele, onetwe, onethi, onefon, onefif, onesin, onesev, onegin) {
   $(function() {
      var ctx = document.getElementById("Chart").getContext('2d');//2차
      var myChart = new Chart(ctx, {
         type: 'horizontalBar',
         data: {
            labels: ["전국", "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주"],
            datasets: [{

               label: "2차 지역별 백신 백분율",
               data: [oneone, onetwo, onethr, onefou, onefix, onesix, oneser, oneeig, onenin, oneten, oneele, onetwe, onethi, onefon, onefif, onesin, onesev, onegin], //컨트롤러에서 모델로 받아온다.
               backgroundColor:
                  'rgba(255, 99, 132, 7)',
               borderColor:
                  'rgba(80, 188, 233, 0.2)',
               borderWidth: 1
            }
            ]
         },
         options: {
            legend: {
               display: false
            },
            scales: {
               xAxes: [{
                  ticks: {
                     max: oneone*3/2
                  }
               }],
               yAxes: [{
                  ticks: {

                  }
               }]
            }

         },
         plugins: plugin
      });
   })
}

graph.G7 = function(United, America, Canada, Germany, Italy, Japan, England, one, ko) {
   $(function() {
      var ctx = document.getElementById("logChart").getContext('2d');
      var myChart = new Chart(ctx, {
         type: 'horizontalBar',
         data: {
            labels: ["미국", "캐나다", "프랑스", "독일", "이탈리아", "일본", "영국", "지구촌", "한국"],
            datasets: [{

               label: "100명당 접종된 백신수",
               data: [United, America, Canada, Germany, Italy, Japan, England, one, ko], //컨트롤러에서 모델로 받아온다.
               backgroundColor:
                  'rgba(255, 99, 132, 7)',
               borderColor:
                  'rgba(80, 188, 233, 0.2)'

               ,
               borderWidth: 1
            }
            ]
         },
         options: {
            legend: {
               display: false
            },
            scales: {
               yAxes: [{
                  ticks: {
                     beginAtZero: true
                  }
               }]
            }
         },
         plugins: plugin
      });
   })
}
graph.tab = function(){
   var tabList = document.querySelectorAll('.tab_list_wrap .tab_list')
   Array.prototype.forEach.call(tabList, function(list) {
      list.children[0].addEventListener('click', function(e) {
         e.preventDefault()
         var tabContent = document.querySelectorAll('.tab_container .tab_content')
         var tabNum = this.parentElement.getAttribute('data-tabnum')
         Array.prototype.forEach.call(tabContent, function(cont, i) {
            cont.style.display = 'none'
            tabList[i].className = 'tab_list'
         })
         tabContent[tabNum].style.display = 'block'
         if (list.className.indexOf('tab_active') == -1) {
            list.className = 'tab_list tab_active'
         }
      })
   })
}