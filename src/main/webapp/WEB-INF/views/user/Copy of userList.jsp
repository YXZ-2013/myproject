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
</head>
<body>
	<div id="toolbar">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
	</div>
	<table id="tt" class="easyui-datagrid" title="用户列表" style="width:100%;height:400px" 
		data-options="rownumbers:true,pagination:true,toolbar:'#toolbar'">
		<thead>
			<tr>
				<th data-options="field:'id',width:'15%'">id</th>
				<th data-options="field:'username',width:'15%'">username</th>
				<th data-options="field:'eamail',width:'15%'">email</th>
				<th data-options="field:'realname',width:'5%'">realname</th>
				<th data-options="field:'mobileNumber',width:'10%'">mobileNumber</th>
				<th data-options="field:'registerTime',width:'15%'">registerTime</th>
				<th data-options="field:'ipsIdentification',width:'15%',align:'right'">ips</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.username }</td>
					<td>${user.email }</td>
					<td>${user.realname }</td>
					<td>${user.mobileNumber }</td>
					<td><fmt:formatDate value="${user.registerTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${user.ipsIdentification }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>