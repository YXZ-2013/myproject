<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/js/admin/user.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table id="gridUser"></table>
	<div id="dlgForm">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" class="easyui-form" method="post">
			<table cellpadding="5px;">
					<input  type="hidden" name="id" value="${user.id}" />
				<tr>
					<td><label for="username">用户名:</label></td>
					<td><input class="easyui-textbox" type="text" name="username" value="${user.username }" data-options="required:true" /></td>
				</tr>
				<tr>
					<td><label for="mobileNumber">电话号码:</label></td>
					<td><input class="easyui-textbox" type="text" name="mobileNumber" value="${user.mobileNumber }" data-options="required:true" /></td>
				</tr>
				<tr>
					<td><label for="password">密码:</label></td>
					<td><input class="easyui-textbox" type="text" name="password" value="${user.password }" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label for="repassword">重复密码:</label></td>
					<td><input class="easyui-textbox" type="text" name="repassword" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label for="referee">重复密码:</label></td>
					<td><input class="easyui-textbox" type="text" name="referee"/></td>
				</tr>
			</table>  
		</form> 
		<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	  </div>
	</div>
    <script>
    	//提交表单
		function submitForm(){
			//显示进度条
			$.messager.progress();
			$('#ff').form('submit', {
				url: '${pageContext.request.contextPath}/user/userEdit',
				onSubmit: function(){
					var isValid = $(this).form('validate');
					if (!isValid){
						$.messager.progress('close');	// 当form不合法的时候隐藏工具条
					}
					return isValid;	// 返回false将停止form提交 
				},
				success: function(data){
					$.messager.progress('close');// 当成功提交之后隐藏进度条
					$('#dlgForm').dialog('close');//关闭添加用户对话框
					$('#gridUser').datagrid('reload');//重新加载数据
				}
			});
		}
    	
    	//清空表单
		function clearForm(){
			$('#ff').form('clear');
		}
    	
    	//注册用户
    	function append(){
    		$('#dlgForm').show();
			$('#dlgForm').dialog({   
			    title: '添加用户',   
			    width: 400,   
			    height: 400,
			    minimizable:true,
			    maximizable:true,
			    resizable:true,
			    closed: false,   
			    modal: true  
			});   
    	}
    	
    	//编辑用户
    	function edit(){
    		var row = datagrid.datagrid('getSelected');
    		if (row != null) {
    			$.messager.progress();
    			$.get('${pageContext.request.contextPath}/user/userEdit',
    					{id:row.id},
    					function(data){
    						$.messager.progress('close');
    		    			$('#dlgForm').form('load', data);
    						$('#dlgForm').show();
	    					$('#dlgForm').dialog({   
	    	    			    title: '编辑用户',   
	    	    			    width: 400,   
	    	    			    height: 400,
	    	    			    minimizable:true,
	    	    			    maximizable:true,
	    	    			    resizable:true,
	    	    			    closed: false,   
	    	    			    modal: true  
	    	    			});
    					}
    			);
    			$('#dlgForm').form('load','${pageContext.request.contextPath}/user/userEdit?id='+row.id);
    			$('#dlgForm').show();
    		}else{
    			$.messager.alert('提示', '请选择要编辑的记录！', 'error');
    		}
    	}
    	//删除用户
    	function remove(){
    		var row = datagrid.datagrid('getSelected');
    		if(row != null){
    			$.messager.confirm('询问', '您是否要删除当前资源？',function(b) {
    				if(b){
		    			$.messager.progress();
		    			$.post('${pageContext.request.contextPath}/user/userRemove',
		    					{id:row.id},
		    					function(data){
		    						if(data.success){
		    							datagrid.datagrid('reload');
		    							$.messager.alert('提示',data.msg,'info');
		    						}else{
		    							$.messager.alert('提示',data.msg,'error');
		    						}
		    						$.messager.progress('close');
		    					},'JSON');
    					}
    			})
    			
    		}else{
    			$.messager.alert('提示', '请选择要删除的用户！', 'error');
    		}
    	}
    	
	</script> 
</body>
</html>