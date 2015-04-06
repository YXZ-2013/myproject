<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:250px;padding:10px;">
	<div class="easyui-accordion">
		<div title="用户管理" style="overflow:auto;padding:10px;display:block">
			<ul>
				<li><a href="${pageContext.request.contextPath}/manager/user/userList" target="content">用户列表</a></li>
				<li><a href="#" target="content">basic</a></li>
				<li><a href="#">权限分配</a></li>
			</ul>
		</div>
		<div title="借款管理" style="overflow:auto;padding:10px;display:block">
		</div>
		<div title="资金管理" style="overflow:auto;padding:10px;display:block">
		</div>
		<div title="菜单管理" style="overflow:auto;padding:10px;display:block">
		</div>
	</div>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">
	</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center'">
<%-- 	<iframe frameborder="0" width="100%" height="100%" scrolling="auto" src="${pageContext.request.contextPath}/index_center"  name="content"></iframe> --%>
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
	<table id="gridUser"></table>
	</div>
</body>
</html>