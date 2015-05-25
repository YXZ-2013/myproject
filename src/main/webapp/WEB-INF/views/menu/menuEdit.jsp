<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript">
	$(functioin(){
		$('#ff').form({
			url:'${pageContext.request.contextPath}/menu/updateMenu',
			onSubmit:function(){
				$.messager.progress();
				var isValid = $(this).form('validate');
				if(!isValid){
					$.messager.progress('close');
				}
				return isValid;
			},
			success : function(result){
				$.messager.progress('close');// 当成功提交之后隐藏进度条
				$('#dlgForm').dialog('close');//关闭添加用户对话框
			}
			
		})
	})
	</script>
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
					<td><input class="easyui-textbox" type="text" name="name" value="${menu.name }" data-options="required:true" /></td>
				</tr>
				<tr>
					<td><label for="url">资源路径:</label></td>
					<td><input class="easyui-textbox" type="text" name="url" value="${menu.url}"  /></td>
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
					<td><input class="easyui-textbox" type="text" name="parentId" value="${menu.parentId }" /></td>
				</tr>
			</table>  
		</form> 
	  </div>
	</div>
</body>
</html>