<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-util.js"></script>
 </head>
 <body>
	<table id="gridLoan" ></table>
	<script type="text/javascript">
		var datagrid;
		$(function(){
// 			$("form > div").css("margin" , "10px 0px 0px 0px");
			datagrid = $('#gridLoan').datagrid({   
			    url:'${pageContext.request.contextPath}/verify/loanList',
			    fit:true,
			    fitColumns:true,
			    rownumbers:true,
			    columns:[[   
			        {field:'id',title:'ID',width:'12%',sortable:true},   
			        {field:'name',title:'借款人',width:'10%',sortable:true}, 
			        {field:'sex',title:'性别',width:'3%',sortable:true},
			        {field:'education',title:'文化程度',width:'10%'}, 
			        {field:'longTermResidence',title:'居住地址',width:'6%'},
			        {field:'marriageSuit',title:'婚姻状况',width:'6%'},
			        {field:'yearlyIncome',title:'年收入',width:'6%'}
			        
			    ]],
				pagination : true,
				pageSize : 20,
				singleSelect : true
			});  
		});
	</script>
  </body>
</html>
