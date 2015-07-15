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
<SCRIPT type="text/javascript" src="${ctx }/js/role/role.js" ></SCRIPT>
<SCRIPT type="text/javascript" src="${ctx }/js/role/searchbox.js" ></SCRIPT>
<title>角色管理</title>

</head>
<body>

	
 	<div id= "" style="height: 5%">
 		<INPUT id = "ss" type="text" name="username" style="width: 200px;" >
 	</div>
 	<div id= "" style="height: 95%">
		<table id="gridRloe" ></table>
	</div>
	
</body>
</html>