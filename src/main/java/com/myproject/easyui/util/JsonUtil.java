package com.myproject.easyui.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

	public static String writeJson(Object object) {
		String json = JSON.toJSONStringWithDateFormat(object,
				"yyyy-MM-dd HH:mm:ss");
		return json;
	}
}
