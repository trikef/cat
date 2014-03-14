$(function(){
  setInterval( function(){
	var etime = new Date((new Date().getFullYear())+"/"+$("#eat-time-1").text());
    $("#time").text(Math.floor((new Date() -etime)/ (60*1000)));
  }, 1000);
});