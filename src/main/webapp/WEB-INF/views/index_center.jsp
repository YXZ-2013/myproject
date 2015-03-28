<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="easyui-panel" style="width:100%;height:200px;padding:10px;border: 0px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west'" style="width:50%;padding:10px;border: 0px;">
				<div id="p1" class="easyui-panel" title="系统信息" style="width:100%;height:150px;padding:10px;">
					<ul>
						<li>java版本:${systemInfo.javaVersion }</li>
						<li>操作系统:${systemInfo.os }</li>
						<li>使用内存/总内存:${systemInfo.totalRam }M/${systemInfo.usedRam }M</li>
					</ul>
				</div>
			</div>
			<div data-options="region:'east'" style="width:50%;padding:10px;border: 0px;">
				<div id="p2" class="easyui-panel" title="系统信息" style="width:100%;height:150px;padding:10px;">
					<ul>
						<li>java版本:${systemInfo.javaVersion }</li>
						<li>操作系统:${systemInfo.os }</li>
						<li>使用内存/总内存:${systemInfo.totalRam }M/${systemInfo.usedRam }M</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="easyui-panel" style="width:100%;height:200px;padding:10px;border: 0px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west'" style="width:50%;padding:10px;border: 0px;">
				<div id="p1" class="easyui-panel" title="系统信息" style="width:100%;height:150px;padding:10px;">
					<ul>
						<li>java版本:${systemInfo.javaVersion }</li>
						<li>操作系统:${systemInfo.os }</li>
						<li>使用内存/总内存:${systemInfo.totalRam }M/${systemInfo.usedRam }M</li>
					</ul>
				</div>
			</div>
			<div data-options="region:'east'" style="width:50%;padding:10px;border: 0px;">
				<div id="p2" class="easyui-panel" title="系统信息" style="width:100%;height:150px;padding:10px;">
					<ul>
						<li>java版本:${systemInfo.javaVersion }</li>
						<li>操作系统:${systemInfo.os }</li>
						<li>使用内存/总内存:${systemInfo.totalRam }M/${systemInfo.usedRam }M</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>