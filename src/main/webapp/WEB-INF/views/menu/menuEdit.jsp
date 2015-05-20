<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="dlgForm">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" class="easyui-form" method="post">
			<table cellpadding="5px;">
				<tr>
					<td><label for="id">id:</label></td>
					<td><input class="easyui-textbox" type="text" name="id" value="${menu.id }" data-options="required:true" /></td>
				</tr>
				<tr>
					<td><label for="name">资源名称:</label></td>
					<td><input class="easyui-textbox" type="text" name="name" value="${menu.username }" data-options="required:true" /></td>
				</tr>
				<tr>
					<td><label for="url">资源路径:</label></td>
					<td><input class="easyui-textbox" type="text" name="url" value="${menu.url}" data-options="required:true" /></td>
				</tr>
				<tr>
					<td><label for="type">类型:</label></td>
					<td><input class="easyui-textbox" type="text" name="type" value="${menu.type }" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label for="seqNum">排序:</label></td>
					<td><input class="easyui-textbox" type="text" name="seqNum" value="${menu.seqNum}" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label for="description">备注:</label></td>
					<td><input class="easyui-textbox" type="text" name="description" value="${menu.description }" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label for="parentId">父节点:</label></td>
					<td><input class="easyui-textbox" type="text" name="parentId" value="${menu.parentId }" data-options="required:true"/></td>
				</tr>
			</table>  
		</form> 
		<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	  </div>
	</div>
</body>
</html>