<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<table id="gridPermission"></table>
	<script type="text/javascript">
		var datagrid;
		$(function(){
			datagrid = $('#gridPermission').datagrid({   
			    url:'${pageContext.request.contextPath}/user/permissionList',
			    fit:true,
			    fitColumns:true,
			    rownumbers:true,
			    columns:[[   
			        {field:'id',title:'ID',width:'20%',sortable:true},   
			        {field:'name',title:'权限名称',width:'20%',sortable:true},   
			        {field:'email',title:'权限描述',width:'50%'}   
			    ]],
				pagination : true,
				pageSize : 10,
				singleSelect : true
			});  
		})
	</script>
</body>
</html>