<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$('#ff').form({
			url:'${pageContext.request.contextPath}/menu/updateMenu',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding:10px 60px 20px 60px">
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
