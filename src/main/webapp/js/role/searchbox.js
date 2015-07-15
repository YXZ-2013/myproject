
$(function(){
	var hideIndexs = new Array();
	$('#ss').searchbox({
		
	    width: 200,
	    searcher: function (value) {
	        hideIndexs.length = 0;
	        if (value == '请输入查询内容') {
	            value = '';
	        }
	        //结束datagrid的编辑.
	        endEdit();
	        var rows = $('#gridRloe').datagrid('getRows');

	        var cols = $('#gridRloe').datagrid('options').columns[0];

	        for (var i = rows.length - 1; i >= 0; i--) {
	            var row = rows[i];
	            var isMatch = false;
	            for (var j = 0; j < cols.length; j++) {

	                var pValue = row[cols[j].field];
	                if (pValue == undefined) {
	                    continue;
	                }
	                if (pValue.toString().indexOf(value) >= 0) {
	                    isMatch = true;
	                    break;
	                }
	            }
	            if (!isMatch)
	                hideIndexs.push(i);
	            $('#gridRloe').datagrid('refreshRow', i);
	        }
	    },
	    prompt: '请输入查询内容'
	});
	function endEdit() {
	    var rows = $('#gridRloe').datagrid('getRows');
	    for (var i = 0; i < rows.length; i++) {
	        $('#gridRloe').datagrid('endEdit', i);
	    }
	}
	
});
