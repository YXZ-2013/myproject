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
	<table id="gridWithdraw" ></table>
	<script type="text/javascript">
		var datagrid;
		$(function(){
// 			$("form > div").css("margin" , "10px 0px 0px 0px");
			datagrid = $('#gridWithdraw').datagrid({   
			    url:'${pageContext.request.contextPath}/withdraw/withdrawList',
			    fit:true,
			    fitColumns:true,
			    rownumbers:true,
			    columns:[[   
			        {field:'id',title:'ID',width:'10%',sortable:true},   
			        {field:'userId',title:'用户名',width:'12%',sortable:true}, 
			        {field:'actualMoney',title:'提现金额',width:'5%',sortable:true},
			        {field:'fee',title:'手续费',width:'4%'}, 
			        {field:'bankCard',title:'银行卡',width:'20%'},
			        {field:'status',title:'状态',width:'6%'},
			        {field:'time',title:'时间',width:'10%',sortable:true,formatter: function(value,row,index){
			        	if (value != null) {
			        		var date = new Date(value);
			        		return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
			        		+ date.getDate();
			        	}
			        }}
			    ]],
				pagination : true,
				pageSize : 20,
				singleSelect : true
			});  
		});
	</script>
  </body>
</html>
