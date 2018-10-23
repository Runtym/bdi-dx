<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<body>
<form>
	언어1 : <select id="source">
				<option value="ko">ko</option>
				<option value="en">en</option>
			</select>
	
	언어2 : <select id="target">
				<option value="en">en</option>
				<option value="ko">ko</option>
			</select>
	번역내용 : <textarea id="text" onkeyup="enterKey()"></textarea>
	번영후 : <textarea id="transText"></textarea>
	<br>
	<button type="button" onclick="trans()">번역</button> 
</form>
<script>
	function enterKey(e){
		 if (window.event.keyCode == 13) {
			 trans();
		 }
	}
	function trans(){
		var source = document.querySelector('#source').value;
		var target = document.querySelector('#target').value;
		var text = document.querySelector('#text').value;
		var param = 'source=' + source + '&target=' + target + '&text=' + text;
		var tt = document.querySelector('#transText');
		var conf = {
				url : encodeURI('/trans?' + param),
				success : function(res){
					res = JSON.parse(res);
					tt.value = res.message.result.translatedText;
				}
		};
		au.send(conf);
	}
</script>
</body>
</html>