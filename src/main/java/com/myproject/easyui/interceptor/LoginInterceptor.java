package com.myproject.easyui.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.model.SessionInfo;

public class LoginInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = Logger.getLogger(LoginInterceptor.class);

	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 在调用Controller具体方法之前拦截
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		if (excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}

		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		if (sessionInfo == null || sessionInfo.getUserId().equalsIgnoreCase("")) {// 如果没有登录或登录超时
			request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}

		if (sessionInfo.getResourceList() != null
				&& !sessionInfo.getResourceList().contains(url)) {//
			// 如果当前用户没有访问此资源的权限
			request.setAttribute("msg", "您没有访问此资源的权限！<br/>请联系超管赋予您<br/>[" + url
					+ "]<br/>的资源访问权限！");
			request.getRequestDispatcher("/error/noSecurity.jsp").forward(
					request, response);
			return false;
		}

		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
