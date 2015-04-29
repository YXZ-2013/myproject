package com.myproject.easyui.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.myproject.easyui.util.ExceptionUtil;

/**
 * @author yinxunzhi
 * @creatTime 2015年4月29日上午11:26:42
 * @version 1.0
 * @description 
 */
public class BaseController {
	private static final Logger logger = Logger.getLogger(BaseController.class);

	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object,HttpServletResponse response) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			logger.debug(ExceptionUtil.getExceptionMessage(e));
		}
	}
}
