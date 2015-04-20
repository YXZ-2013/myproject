var datagrid;
$(function(){
	$("form > div").css("margin" , "10px 0px 0px 0px");
	
	datagrid = $('#gridRloe').datagrid({   
	    url:'${pageContext.request.contextPath}/user/roleList',
	    fit:true,
	    fitColumns:true,
	    rownumbers:true,
	    columns:[[   
	        {field:'id',title:'ID',width:'10%',sortable:true},   
	        {field:'name',title:'用户名',width:'15%',sortable:true},   
	        {field:'description',title:'备注',width:'15%'}  
	        
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