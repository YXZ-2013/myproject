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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-util.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/role.js"></script>

</head>
<body>
	<table id="gridRloe" ></table>
	<script type="text/javascript">
		var datagrid;
		$(function(){
			$("form > div").css("margin" , "10px 0px 0px 0px");
			
			datagrid = $('#gridRloe').datagrid({   
			    url:'${pageContext.request.contextPath}/role/roleList',
			    fit:true,
			    fitColumns:true,
			    rownumbers:true,
			    columns:[[   
			        {field:'id',title:'ID',width:'10%',sortable:true},   
			        {field:'name',title:'用户名',width:'15%',sortable:true},   
			        {field:'description',title:'备注',width:'15%'}  
			        
			    ]],
			    toolbar:[
				    {
						text : '增加',
						iconCls : 'icon-add',
						handler : function() {
							append();
						}
					},'-',{
						text : '删除',
						iconCls : 'icon-remove',
						handler : function() {
							remove();
						}
					}, '-', {
						text : '修改',
						iconCls : 'icon-edit',
						handler : function() {
							edit();
						}
					}, '-', {
						text : '取消选中',
						iconCls : 'icon-undo',
						handler : function() {
							datagrid.datagrid('clearSelections');
							datagrid.datagrid('unselectAll');
						}
					}, '-', {
						text : '批量修改用户角色',
						iconCls : 'icon-edit',
						handler : function() {
							editRole();
						}
					}, '-'],
				pagination : true,
				pageSize : 20,
				singleSelect : true
			});  
		})
	</script>
</body>
</html>