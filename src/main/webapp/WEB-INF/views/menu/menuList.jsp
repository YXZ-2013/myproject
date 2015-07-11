<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			fitColumns : true,
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
				e.preventDefault();
				$(this).treegrid('unselectAll');
				$(this).treegrid('select', row.id);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
			onLoadSuccess : function() {
				parent.$.messager.progress('close');
				treeGrid.treegrid('collapseAll');
			}
		})
	})
	
	function editFun(id){
		if (id != undefined) {
			treeGrid.treegrid('select', id);
		}
		var node = treeGrid.treegrid('getSelected');
		if (node) {
			parent.$.modalDialog({   
			    title: '编辑菜单',   
			    width: 500,   
			    height: 500,   
			    closed: false,   
			    cache: false,   
			    href: '${pageContext.request.contextPath}/menu/editMenu?id='+node.id,   
			    buttons : [ {
					text : '添加',
					handler : function() {
						parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
						var f = parent.$.modalDialog.handler.find('#ff');
						f.submit();
					}
				} ]
			});   
		}
	}
	
	function deleteFun(id) {
		if (id != undefined) {
			treeGrid.treegrid('select', id);
		}
		var node = treeGrid.treegrid('getSelected');
		if (node) {
			$.messager.confirm('询问', '您是否要删除当前资源？', function(b) {
				if (b) {
					$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/menu/delMenu', {
						id : node.id
					},function(data){
						if (data.success) {
							treeGrid.treegrid('reload');
							$.messager.alert('提示',data.msg,'info');
						}else{
							$.messager.alert('提示',data.msg,'error');
						}
						$.messager.progress('close');
					},'JSON');
				}
			})
		}
	}
	
	function addFun() {
		var row = treeGrid.treegrid('getSelected');
		if(row == null){
			parent.$.messager.alert('提示','请选择父菜单后添加！');
			return;
		}
		parent.$.modalDialog({
			title : '添加资源',
			width : 500,
			height : 500,
			href : '${pageContext.request.contextPath}/menu/addMenu',
			onLoad : function(){
				var f = parent.$.modalDialog.handler.find('#ff');
				f.find('#pid').val(row.id);
				f.find('#pname').val(row.name);
			},
			buttons : [{
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#ff');
					f.submit();
				}
			}]
		});
	}
	
	function redo() {
		treeGrid.treegrid('expandAll');
	}

	function undo() {
		treeGrid.treegrid('collapseAll');
	}
	</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div  data-options="region:'center',border:false" title="" style="overflow: hidden;">
			<table id="treeGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
<%-- 		<c:if test="${fn:contains(sessionInfo.resourceList, '/resourceController/addPage')}"> --%>
<%-- 		</c:if> --%>
		<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
		<a onclick="redo();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'resultset_next'">展开</a> 
		<a onclick="undo();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'resultset_previous'">折叠</a> <a onclick="treeGrid.treegrid('reload');" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'transmit'">刷新</a>
	</div>
</body>
</html>