<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>	
<link rel="stylesheet" type="text/css" href="${resPath}/dhtmlx/skins/skyblue/dhtmlx.css"/>
	<script>
	var jpGird;
	var AjaxObject = function (conf){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState ==4){
				if(xhr.status==200){
					conf.suc(xhr.responseText);
				}
			}
		}
		xhr.open(conf.method,conf.url);
		xhr.send();
	}
	
	window.addEventListener('load',function(){

		jpGrid = new dhtmlXGridObject('divGrid');
		jpGrid.setImagePath('${resPath}/dhtmlx/skins/skyblue/imgs/dhxgrid_skyblue/');
		jpGrid.setHeader('번호,이름,설명');
		jpGrid.setColumnIds('jpnum,jpname,jpdesc');
		jpGrid.setColAlign('center,center,center');
		jpGrid.setColTypes('ro,ed,ed');
		jpGrid.setColSorting('int,str,str');
		jpGrid.init(); 
		var conf = {method:'GET',url:'/japans',suc:function(res){
			res = JSON.parse(res);
			jpGrid.parse(res,'js');
		}}
		var ao = new AjaxObject(conf)
	});
	
	 
</script>
</head>
<body>
	<div id="divGrid" style="width:500px; height:350px; background-color:white;"></div>
	<button onclick="test()">테스트</button>
</body>
</html>