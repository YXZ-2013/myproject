<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){
	 var L=($(window).width()/2)-($(".login").width()/2);
     var T=($(window).height()/2)-($(".login").height()/2);
     $(".login").css({"left":L,"top":T});

})
</script>
<title>Insert title here</title>
</head>
<body style="position:relative;background-color:#e0ecff;">
	<div class="login" style="position:absolute;width:500px;height:200px;">
		<div id="loginPanel">
			<form id="loginInputForm" method="post">
				<table cellpadding="5" style="margin:30px auto 10px;">
		    		<tr>
		    			<td>用户名:</td>
		    			<td><input class="easyui-textbox" type="text" name="name" style="width: 200px;" data-options="required:true,missingMessage:'请填写登录名称'"></input></td>
		    		</tr>
		    		<tr>
		    			<td>密码:</td>
		    			<td><input class="easyui-textbox" type="password" name="name" style="width: 200px;" data-options="required:true,missingMessage:'请填写密码'"></input></td>
		    		</tr>
	    		</table>
			</form>
			<div style="text-align:center;padding:5px">
		    	<a style="margin:0 20px 0 55px;"href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">登陆</a>
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
		    </div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#loginPanel').panel({
				width : 500,
				height : 200,
				title : '管理员登录'
			});
		})
	</script>
</body>
</html>