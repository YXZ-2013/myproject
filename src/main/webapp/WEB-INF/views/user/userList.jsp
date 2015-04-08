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
	<table id="gridUser"></table>
	<script type="text/javascript">
		$(function(){
			$("form > div").css("margin" , "10px 0px 0px 0px");
			
			$('#gridUser').datagrid({   
			    url:'${pageContext.request.contextPath}/manager/user/userList',
			    fit:true,
			    columns:[[   
			        {field:'id',title:'ID',width:'10%',sortable:true},   
			        {field:'username',title:'用户名',width:'15%',sortable:true},   
			        {field:'email',title:'邮箱',width:'15%'},   
			        {field:'realname',title:'姓名',width:'5%'},   
			        {field:'registerTime',title:'注册时间',width:'15%',sortable:true,formatter: function(value,row,index){
			        	if (value != null) {
			        		var date = new Date(value);
			        		return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
			        		+ date.getDate();
			        	}
			        }},   
			        {field:'ipsIdentification',title:'ips',width:'15%',sortable:true} 
			    ]],
			    toolbar:[
	                {
						text : "添加" , iconCls : "icon-save" , handler : function(){
							$("#dlgForm").show();
							$('#dlgForm').dialog({   
							    title: '添加用户',   
							    width: 400,
							    minimizable : true,
							    maximizable : true,	
							    height: 400,   
							    modal: true  
							});   

						}
					},
					"-",
					{
						text : "修改" , iconCls : "icon-edit" , handler : function(){
						}
			    	}
					],
				pagination : true,
				pageSize : 20,
				singleSelect : true
			});  
		})
	</script>
	
	<div id = "dlgForm" style = "display:none;padding:5px">
		<form id="ff" method="post">  
		    <div>  
		        <label for="name">用 &nbsp;户&nbsp;名:</label>  
		        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />  
		    </div>  
		    <div>  
		        <label for="email">电话号码:</label>  
		        <input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" />  
		    </div>
		    <div>  
		        <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>  
		        <input class="easyui-validatebox" type="text" name="password"/>  
		    </div>  
		    <div>  
		        <label for="repassword">重复密码:</label>  
		        <input class="easyui-validatebox" type="text" name="repassword"/>  
		    </div>  
		</form>  
	</div>
</body>
</html>