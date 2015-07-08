<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$('#addRoleForm').form({
			url:'${pageContext.request.contextPath}/user/roleSave',
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
			success : function(data) {
				$.messager.progress('close');// 当成功提交之后隐藏进度条
				parent.$.modalDialog.openner_datagrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
				parent.$.modalDialog.handler.dialog('close');
				
			}
		});
		
	});
</script>
<div id = "addForm" class="easyui-layout" data-options="fit:true,border:false" >
<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding:10px 60px 20px 60px">
    <form id="addRoleForm" class="easyui-form" method="post">
		<table cellpadding="5px;" >
			<input  type="hidden" name="id" value="${role.id }" />
			<tr>
				<td><label for="name">角色名:</label></td>
				<td><input class="easyui-textbox" type="text" name="name" value="${role.name }" data-options="required:true" missingMessage="不能为空"/></td>
			</tr>
			<tr>
				<td><label for="description">备注:</label></td>
				<td><input class="easyui-textbox" type="text" name="description" value="${role.description }" data-options="required:true" missingMessage="不能为空"/></td>
			</tr>
		</table> 
	</form> 
  </div>
</div>
