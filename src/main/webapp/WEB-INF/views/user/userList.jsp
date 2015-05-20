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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-util.js"></script>
</head>
<body>
	<table id="gridUser"></table>
	<script type="text/javascript">
		var datagrid;
		$(function(){
			$("form > div").css("margin" , "10px 0px 0px 0px");
			
			datagrid = $('#gridUser').datagrid({   
			    url:'${pageContext.request.contextPath}/user/userList',
			    fit:true,
			    fitColumns:true,
			    rownumbers:true,
			    columns:[[   
			        {field:'id',title:'ID',width:'10%',sortable:true},   
			        {field:'username',title:'用户名',width:'15%',sortable:true},   
			        {field:'email',title:'邮箱',width:'15%'},   
			        {field:'realname',title:'姓名',width:'5%'},   
			        {field:'registerTime',title:'注册时间',width:'15%',sortable:true,formatter: function(value,row,index){
			        	if (value != null) {
			        		var date = new Date(value);
			        		return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
			        		+ date.getDate();
			        	}
			        }},   
			        {field:'ipsIdentification',title:'ips',width:'15%',sortable:true} 
			    ]],
			    toolbar:[
				    {
						text : '增加',
						iconCls : 'icon-add',
						handler : function() {
							append();
						}
					},'-',{
						text : '删除',
						iconCls : 'icon-remove',
						handler : function() {
							remove();
						}
					}, '-', {
						text : '修改',
						iconCls : 'icon-edit',
						handler : function() {
							edit();
						}
					}, '-', {
						text : '取消选中',
						iconCls : 'icon-undo',
						handler : function() {
							datagrid.datagrid('clearSelections');
							datagrid.datagrid('unselectAll');
						}
					}, '-', {
						text : '批量修改用户角色',
						iconCls : 'icon-edit',
						handler : function() {
							editRole();
						}
					}, '-'],
				pagination : true,
				pageSize : 20,
				singleSelect : true
			});  
		});
	</script>
	<div id="dlgForm">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" class="easyui-form" method="post">
			<table cellpadding="5px;">
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
    	
    	
	</script> 
</body>
</html>