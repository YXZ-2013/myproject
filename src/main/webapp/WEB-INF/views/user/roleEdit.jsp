<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    <div id="addForm" >
		<div style="padding:10px 60px 20px 60px">
			<form id="addRoleForm" class="easyui-form" method="post" >
				<table cellpadding="5px;" >
					<input  type="hidden" name="id" value="${role.id }" />
					<tr>
					<td><label for="name">角色名:</label></td>
					<td><input class="easyui-textbox" type="text" name="name" value="${role.name }" data-options="required:true" /></td>
				</tr>
				<tr>
					<td><label for="description">备注:</label></td>
					<td><input class="easyui-textbox" type="text" name="description" value="${role.description }" data-options="required:true" /></td>
				</tr>
				</table>
			</form>
			<br><br>
			<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitRoleForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearRoleForm()">Clear</a>
	    	</div>
		</div>
	</div>
  </body>
</html>
