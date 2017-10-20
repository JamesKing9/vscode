<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2016, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>使用s:bean标签创建JavaBean的实例</title>
</head>
<body>
<!-- 使用bean标签创建一个Person类的实例 -->
<s:bean name="org.crazyit.app.dto.Person">
	<!-- 使用param标签为Person类的实例传入参数 -->
	<s:param name="name" value="'yeeku'"/>
	<s:param name="age" value="29"/>
	<!-- 因为在bean标签内，Person实例位于ValueStack的栈顶，
		故可以直接访问lee.Person实例 -->
	Person实例的name为：<s:property value="name"/><br/>
	Person实例的age为：<s:property value="age"/>
</s:bean>
</body>
</html>
