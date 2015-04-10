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