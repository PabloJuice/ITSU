/* globals Chart:false, feather:false */

(function () {
  'use strict'

  feather.replace()

  var ctx = document.getElementById('myChart')
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
        '04.11',
        '05.11',
        '06.11',
        '07.11',
        '08.11',
        '09.11',
        '10.11',
        '11.11',
        '12.11',
        '13.11',
        '14.11',
        '15.11',
        '16.11',
        '17.11'
      ],
      datasets: [{
        data: [
          9524,
          9850,
          9712,
          10746,
          9397,
          8678,
          10179,
          10611,
          11057,
          11787,
          12524,
          10681,
          9832,
          11968
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#dc3545',
        borderWidth: 4,
        pointBackgroundColor: '#dc3545'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })
})()
