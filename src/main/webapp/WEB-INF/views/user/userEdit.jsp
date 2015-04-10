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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div id = "dlgForm" style = "display:none;padding:5px">
		<form id="ff" method="post">  
		    <div>  
		        <label for="username">用 &nbsp;户&nbsp;名:</label>  
		        <input class="easyui-validatebox" type="text" name="username" value="${user.username }" data-options="required:true" />  
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