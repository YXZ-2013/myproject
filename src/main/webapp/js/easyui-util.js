/**
 * 包含easyui的扩展和常用的方法
 * @author yinxunzhi
 * @date 2015-04-10
 */
var sy = $.extend({}, sy);/* 定义全局对象，类似于命名空间或包的作用 */

/**
 * 根据当前组件成圣dialog
 * @author yinxunzhi
 * @date 2015-04-10
 */
sy.dialog = function(options) {
	var opts = $.extend({
		modal : true,
		onClose : function() {
			$(this).dialog('destroy');
		}
	}, options);
	return $('<div/>').dialog(opts);
};



/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 创建一个模式化的dialog
 * 
 * @returns $.modalDialog.handler 这个handler代表弹出的dialog句柄
 * 
 * @returns $.modalDialog.xxx 这个xxx是可以自己定义名称，主要用在弹窗关闭时，刷新某些对象的操作，可以将xxx这个对象预定义好
 */
$.modalDialog = function(options) {
	if ($.modalDialog.handler == undefined) {// 避免重复弹出
		var opts = $.extend({
			title : '',
			width : 840,
			height : 680,
			modal : true,
			onClose : function() {
				$.modalDialog.handler = undefined;
				$(this).dialog('destroy');
			},
			onOpen : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
			}
		}, options);
		opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
		return $.modalDialog.handler = $('<div/>').dialog(opts);
	}
};