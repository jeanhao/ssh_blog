<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<s:head theme="xhtml"/>   
<sx:head parseContent="true"/> 
<title>博文列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="resources/css/styles.css" rel="stylesheet">

</head>
<script type="text/javascript">
	function logout() {
		alert("退出成功！");
	}
</script>
<body>

	<article> <header>
	<div class="toptitle">
		<font size=3 color="#D2691E">a您好， <security:authentication
				property="name" />&nbsp;</font>
		<h1>拾忆点滴，谦卑远航</h1>
		<p class="byline">——蹉跎年华</p>
	</div>

	<object id="swftitlebar" data="resources/images/79514.swf" width="100%"
		height="220" type="application/x-shockwave-flash">
		<param name="allowScriptAccess" value="always">
		<param name="allownetworking" value="all">
		<param name="allowFullScreen" value="true">
		<param name="wmode" value="transparent">
		<param name="menu" value="false">
		<param name="scale" value="noScale">
		<param name="salign" value="1">
	</object>
	<p class="sign">人生可以没有很多东西，却唯独不能没有希望。希望是人类生活的一项重要的价值。有希望之处，生命就生生不息！</p>
	</header>
	<div class="leftbox">
		<div class="vcard box">
			<h2 style="posstion:absolute;">
				<div>
					<h2>
							<font>用户权限： </font>
							<br>
							<security:authentication property="authorities" var="authorities" />
							<ul>
								<c:forEach items="${authorities}" var="authority">
									<li>${authority.authority}</li>
								</c:forEach>
							</ul>
					</h2>
				</div>
				<center>
					<div>
						<c:url value="/logout" var="logoutUrl" />
						<br /> <a href="${logoutUrl}" onclick="logout()">退出登录</a>
						<br /><a href="user/listArticle.action" >博文目录</a>
						<br><a href="user/addArticle.action">发表博文</a>
					</div>
					<security:authorize
						access="hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_BOSS')">
						<form name="form1" action="user/userlist.action" method='GET'>
							<input type="hidden" name="pageNow" value="1" /> <input
								type="hidden" name="orderType" value="id" /> <input
								type="hidden" name="sortInverse" value="1" /> <a
								href="javascript:document.form1.submit();">用户管理界面</a>
						</form>
					</security:authorize>
			</h2>
			</center>
			<h2>个人资料</h2>
			<p class="fn">姓名：曾豪</p>
			<p class="nickname">兴趣：</p>
			<p class="url">职业：学生</p>
			<p class="address">专业：电子信息工程</p>
			<p class="role">现居：武汉市华科大</p>
		</div>
		<div class="blogclass box">
			<h2>博客分类</h2>
			<ul>
				<li><a href="/">java 面向对象(3)</a>
				</li>
				<li><a href="/">spring(25)</a>
				</li>
				<li><a href="/">>ssh 整合(39)</a>
				</li>
			</ul>
		</div>
		<div class="blogclass box">
			<ul id="blog_statistics">
			    <li>原创：<span>30篇</span></li>
			    <li>转载：<span>2篇</span></li>
			    <li>译文：<span>4篇</span></li>
			    <li>评论：<span>7条</span></li>
		</ul>
		</div>
	</div>
	<div class="rightbox box">
		<h2>全部博文</h2>
		<ul>
		<s:iterator value="#request.articles">
			<li>&nbsp;&nbsp;&nbsp;&nbsp;<font size="3px"><a href="user/detailArticle.action?id=${id}">${title}</a></font>
			 <font style="position:absolute;right:250px">点赞(10)&nbsp;&nbsp;评论(5)&nbsp;&nbsp;转载(5)</font></li><br>
		</s:iterator>
		</ul>
		<center>
						<font size="2">共 ${page.pageNow} 页 &nbsp;&nbsp;当前第
						${page.pageNow} 页&nbsp;&nbsp; 共 ${page.totalSize} 条记录&nbsp;&nbsp; 
						<!-- 首页始终显示第一页 --> <a href="user/listArticle.action?pageNow=1">首页</a>
							<!-- 如果有前一页就提交前一页的pageNow值 --> <c:choose><c:when test="${page.hasPre}">
									<a href="user/listArticle.action?pageNow=${page.pageNow-1}">上一页</a></c:when><c:otherwise>
									<a href="user/listArticle.action?pageNow=1">上一页</a></c:otherwise></c:choose>
									 <c:choose><c:when test="${page.hasNext}"><a  href="user/listArticle.action?pageNow=${page.pageNow+1}">下一页</a></c:when>
								<c:otherwise><a href="user/listArticle.action?pageNow=${page.totalPage}">下一页</a></c:otherwise></c:choose> 
							<!-- 尾页始终提交最后一页的pageNow值 -->
							 <em><a href="user/listArticle.action?pageNow=${page.totalPage}">尾页</a></em>
							&nbsp;跳转到: </font>
						<s:form name="myForm" action="user/listArticle.action" method="get" theme="simple">
							<select size="1" name="pageNow" style=" height: 18"
								onchange="submitForm()">
								<c:forEach begin="1" end="${page.totalPage}" varStatus="status">
									<option value="${status.index}" ${status.index==page.pageNow?'selected' : ''}>${status.index}</option>
								</c:forEach>
							</select> 
						</s:form>
					</center>
	</div>
	<div class="blank"></div>
	<div class="Copyright">
			<a href="/">帮助中心</a>
			<a href="/">空间客服</a>
			<a href="/">投诉中心</a>
			<a href="/">空间协议</a>
		<p>Design by DanceSmile</p>
	</div>
	</article>
</body>
<script type="text/javascript">
		function submitForm() {
			var frm = document.myForm;
			frm.submit();
		}
		
		$(document).ready(function() {
			$(".list_tb tr").mouseover(function() {
				$(this).addClass("highlight");
			}).mouseout(function() {
				$(this).removeClass("highlight");
			});
		});
</script>
</html>
