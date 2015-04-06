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
<script type="text/javascript">
	$(function(){
		$('#gridUser').datagrid({   
		    url:'user/userList1',
		    fit:true,
		    columns:[[   
		        {field:'id',title:'ID',width:100},   
		        {field:'username',title:'用户名',width:100},   
		        {field:'mobileNumber',title:'电话',width:100,align:'right'}   
		    ]],
		    toolbar:[
                {
					text : "修改" , iconCls : "icon-edit" , handler : function(){
					}
				},
				"-",
				{
					text : "修改" , iconCls : "icon-edit" , handler : function(){
					}
		    	}
				],
			pagination : true
		});  
	})
</script>
</head>
<body>
	<table id="gridUser"></table>
</body>
</html>