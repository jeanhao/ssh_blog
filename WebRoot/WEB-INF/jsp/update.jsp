<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<base target = "_self">
</head>
<script type="text/javascript">
function submit(){  
 	document.updateform.submit();  
} 
</script>
<body background="resources/images/update.jpg"
	style="margin:0;width:600px;height:400px">
	<c:set var="user" value="${user}" />

	<form name="updateform" action="user/updateOp.action" method="post">
		&gt;<br> <input type="hidden" name="id"
			value="<c:out value="${user.id }"/>" />
<s:debug></s:debug>
		<table class="result-tab" width="100%"
			style="position: absolute; margin-left:180px;margin-top:30px">
			<tr>
				<td><h1>用户信息修改</h1></td>
			</tr>
			<tr>
				<td>名称：<input name="name" type="text" value="${user.name }"
					style="height:20px;width:150px" /><br></td>
			</tr>
			<tr>
				<td>账号：<input name="userName" type="text"
					value="<c:out value="${user.userName}"/>"
					style="height:20px;width:150px"><br></td>
			</tr>
			<tr>
				<td>密码：<input name="password" type="password"
					value="<c:out value="${user.password }"/>"
					style="height:20px;width:150px"><br></td>
			</tr>
			<tr>
				<td>性别：<input type="radio" name="gender" value="男" checked />男<input
					type="radio" name="gender" value="女" />女<br></td>
			</tr>
			<tr>
				<td>邮箱：<input name="email" type="text" value="${user.email}" />
				</td>
			</tr>
			<tr>
				<td><select name="question"
					style="position:relative; top:16px;height:20px;width:150px">
						<option value="${user.question }">密码验证问题选择
						<option value="你的父亲的名字是？">你的父亲的名字是？
						<option value="你的母亲的名字是？">你的母亲的名字是？
						<option value="你的生日是多少？">你的生日是多少？
						<option value="你最喜欢的颜色是？">你最喜欢的颜色是？
						<option value="你的工作是什么？">你的工作是什么？
				</select></td>
			</tr>
			<tr>
				<td><br>密码验证答案：<input name="answer" type="text"
					value="${user.answer}" style="height:20px;width:150px" /></td>
			</tr>
			<tr>
				<td><input type="button" class="button" value="修改" onclick="submit()"
					style=" height: 45px;width: 90px;background-color:#0099FF;	border:hidden;#0033CC;border-radius:5px;" />
					&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"
					style=" height: 45px;width: 90px;background-color:green;	border:hidden;#0033CC;border-radius:5px;" />
				</td>
			</tr>
		</table>
		<br>
	</form>
</body>
</html>
