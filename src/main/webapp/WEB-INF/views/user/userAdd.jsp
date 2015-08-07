<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#role").combotree({
			url:baseUrl+'/user/userAddRole',
	        multiple: true,
	        panelHeight : 'auto'
		});
		
		$('#addUserForm').form({
			url:baseUrl+'/user/userSave',
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
    <form id="addUserForm" class="easyui-form" method="post">
		<table cellpadding="5px;" >
			<input  type="hidden" name="id" value="${role.id }" />
			<tr>
				<td><label for="username">用 &nbsp;户&nbsp;名:</label>  </td>
				<td><input class="easyui-textbox" type="text" name="username" value="${user.username }" data-options="required:true,validType:'length[6,16]'"   missingMessage="请填写用户名" /></td>
			</tr>
			<tr>
				<td><label for="email">电子邮箱:</label></td>
				<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'" missingMessage="请填写Email"/></td>
			</tr>
			<tr>
				<td><label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label></td>
				<td><input class="easyui-textbox" type="password" name="password" data-options="required:true,validType:'length[1,16]'" missingMessage="请填写密码" /></td>
			</tr>
			<tr>
				<td><label for="repassword">重复密码:</label></td>
				<td><input class="easyui-textbox" type="password" name="repassword" data-options="required:true,validType:'length[1,16]'" missingMessage="请先填写密码"/></td>
			</tr>
			<tr>
				<td><label for="roles">角色:</label></td>
				<td><input name="roleIds" id="role"/></td>
			</tr>
		</table> 
	</form> 
  </div>
</div>
