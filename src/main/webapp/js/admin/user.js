var datagrid;
$(function(){
	$("form > div").css("margin" , "10px 0px 0px 0px");
	
	datagrid = $('#gridUser').datagrid({   
	    url:baseUrl+'/user/userList',
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