<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<link rel="stylesheet" type="text/css" href="${ctx }/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx }/css/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx }/css/extEasyUIIcon.css">
<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx }/js/extJquery.js"></script>
<script type="text/javascript" src="${ctx }/js/easyui-util.js"></script>
<script type="text/javascript" src="${ctx }/js/easyui-lang-zh_CN.js"></script>
<%
	String easyuiThemeName = "gray";
	Cookie cookies[] = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("easyuiThemeName")) {
				easyuiThemeName = cookie.getValue();
				break;
			}
		}
	}
%>
<c:if test="${sessionInfo == null or sessionInfo.userId == null }">
	<script type="text/javascript">
		if(self.frameElement != null && self.frameElement.tagName != null && self.frameElement.tagName=="IFRAME"){
			window.parent.location.href='${ctx}/login';
		}
	</script>
</c:if>
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${ctx }/css/themes/<%=easyuiThemeName%>/easyui.css">
<script type="text/javascript">
	var baseUrl = "<%=basePath%>";	
</script>