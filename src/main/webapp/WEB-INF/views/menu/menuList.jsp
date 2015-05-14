<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
	<script type="text/javascript">
	$.canDelete = true;
	$.canEdit = true;
	var treeGrid;
	$(function() {
		treeGrid = $('#treeGrid').treegrid({
			url : '${pageContext.request.contextPath}/admin/menu/menuList',
			idField : 'id',
			treeField : 'name',
			parentField : 'parentId',
			fit : true,
			fitColumns : false,
			border : false,
			frozenColumns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				hidden : true
			} ] ],
			columns : [ [ {
				field : 'name',
				title : '资源名称',
				width : 150
			}, {
				field : 'url',
				title : '资源路径',
				width : 300
			}, {
				field : 'type',
				title : '类型',
				width : 100
			},{
				field : 'seqNum',
				title : '排序',
				width : 40
			}, {
				field : 'parentId',
				title : '上级资源ID',
				width : 150,
				hidden : true
			}, {
				field : 'description',
				title : '备注',
				width : 300
			}, {
				field : 'action',
				title : '操作',
				width : 50,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/images/extjs_icons/pencil.png');
					}
					str += '&nbsp;';
					if ($.canDelete) {
						str += $.formatString('<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/images/extjs_icons/cancel.png');
					}
					return str;
				}
			} ] ],
			toolbar : '#toolbar',
			onContextMenu : function(e, row) {
// 				e.preventDefault();
// 				$(this).treegrid('unselectAll');
// 				$(this).treegrid('select', row.id);
// 				$('#menu').menu('show', {
// 					left : e.pageX,
// 					top : e.pageY
// 				});
			},
			onLoadSuccess : function() {
// 				parent.$.messager.progress('close');

// 				$(this).treegrid('tooltip');
			}
		})
	})
	</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
			<table id="treeGrid"></table>
		</div>
	</div>
</body>
</html>