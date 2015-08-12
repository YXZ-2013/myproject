<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$('#ff').form({
			url:'${pageContext.request.contextPath}/menu/addMenu',
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
		
// 		$('#pid').combotree({
// 			url : '${pageContext.request.contextPath}/menu/tree',
// 			parentField : 'parentId',
// 			lines : true,
// 			panelHeight : 'auto',
// 			value : '${menu.parentId}',
// 			onLoadSuccess : function() {
// 				parent.$.messager.progress('close');
// 			}
// 		});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding:10px 60px 20px 60px">
    <form id="ff" class="easyui-form" method="post">
		<table cellpadding="5px;">
<!-- 			<tr> -->
<!-- 				<td><label for="id">id:</label></td> -->
<!-- 				<td><input class="easyui-textbox" style="width:200px;height:22px" type="text" name="id" value="${menu.id }" data-options="required:true,missingMessage:'资源ID'" /></td> -->
<!-- 			</tr> -->
			<tr>
				<td><label for="name">资源名称:</label></td>
				<td><input class="easyui-textbox" style="width:200px;height:22px" type="text" name="name" value="${menu.name }" data-options="required:true,missingMessage:'资源名称'" /></td>
			</tr>
			<tr>
				<td><label for="url">资源路径:</label></td>
				<td><input class="easyui-textbox" style="width:200px;height:22px" type="text" name="url" value="${menu.url}" data-options="required:true,missingMessage:'资源路径'"/></td>
			</tr>
			<tr>
				<td><label for="type">类型:</label></td>
				<td>
					<select name="type" class="easyui-combobox" data-options="width:200,height:29,editable:false,panelHeight:'auto',required:true,missingMessage:'资源类型'">
						<option value="Management">Management</option>
						<option value="other">other</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="seqNum">排序:</label></td>
				<td><input class="easyui-numberspinner" style="width:80px;" name="seqNum" value="${menu.seqNum}" data-options="required:true,missingMessage:'排序'"></input>
				</td>
			</tr>
			<tr>
				<td><label for="description">备注:</label></td>
				<td><input class="easyui-textbox" type="text" name="description" value="${menu.description }" data-options="missingMessage:'资源描述',multiline:true" style="width:200px;height:80px"/></td>
			</tr>
			<tr id="ptr">
				<td><label for="parentId">父节点:</label></td>
				<td><input id="pid" type="hidden" name="parentId"></input>
				<input id="pname" class="easyui-textbox" style="width: 200px; height: 29px;" readonly="readonly" data-options="missingMessage:'父节点'"></input></td>
			</tr>
		</table>  
	</form> 
  </div>
</div>
