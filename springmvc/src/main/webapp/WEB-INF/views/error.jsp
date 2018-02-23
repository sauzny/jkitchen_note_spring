<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<%--	
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	
	Exception ex = (Exception)request.getAttribute("exception"); 
	String result = ex.getMessage().toString();
	if(result.indexOf("permission") == -1){
		result = "<h1>无权限的操作！</h1><br/><a href='javascript:window.history.go(-1)'>返回</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+request.getContextPath()+"/logout'>退出登录</a>";
	} else {
		result = "{\"statusCode\":\"300\",\"message\":\"无权限的操作！\"}";
	}
--%>
<%	
	String result= "<h1>无权限的操作！</h1><br/>&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+request.getContextPath()+"/logout'>退出登录</a>";
	response.getWriter().print(result);
%>
<a href="<%=request.getContextPath()%>/index.html">返回</a>