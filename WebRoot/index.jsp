<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/Ext/adapter/ext/ext-base.js"></script>
     <script type="text/javascript" src="/Ext/ext-all.js"></script>
      <link rel="stylesheet" type="text/css" href="/Ext/resources/css/ext-all.css" />
       <script type="text/javascript">
         Ext.onReady(function () {
            Ext.MessageBox.alert('标题', 'Hello World!');
         });
    </script>
  </head>
  
  <body>
  jsp页面<br><br>
  <a href="free/login.action">login</a>
  <br><br>
  <a href="free/register.action">register</a>
    <%-- <jsp:forward page="/WEB-INF/jsp/login.jsp"></jsp:forward> --%>
  </body>
</html>
