<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>主页</title>

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
<script type="text/javascript" src="<%=path %>/fckeditor/fckeditor.js">
	function logout() {
		alert("退出成功！");
	}
	          var oFCKeditor=new FCKeditor("personal_Notes.Neirong");
 
          oFCKeditor.BasePath= "<%=path%>/fckeditor/";

	oFCKeditor.Height = 300;

	oFCKeditor.ToolbarSet = "itcastbbs";

	oFCKeditor.ReplaceTextarea();
</script>
<body>

	<article> <header>
	<div class="toptitle">
		<font size=3 color="#D2691E">您好， <security:authentication
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
						<ul>
							<font>用户权限： </font>
							<br>
							<security:authentication property="authorities" var="authorities" />
							<ul>
								<c:forEach items="${authorities}" var="authority">
									<li>${authority.authority}</li>
								</c:forEach>
							</ul>
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
						<form name="form1" action="user/userlist.action" method='get'>
							<input type="hidden" name="pageNow" value="1" /> <input
								type="hidden" name="orderType" value="id" /> <input
								type="hidden" name="sortInverse" value="1" /> <a
								href="javascript:document.form1.submit();">用户管理界面</a>
						</form>
					</security:authorize>
			</h2>
			</center>
		</div>
		<div class="blogclass box">
			<h2>博客分类</h2>
			<ul>
				<li><a href="/">慢生活(3)</a>
				</li>
				<li><a href="/">程序人生(25)</a>
				</li>
				<li><a href="/">经典美文(39)</a>
				</li>
			</ul>
		</div>
		<div class="friends box">
			<h2>最近访客</h2>
			<ul>
				<li><a href="/"><img src="resources/images/01.jpg"> </a>
				</li>
				<li><a href="/"><img src="resources/images/s3.jpg"> </a>
				</li>
				<li><a href="/"><img src="resources/images/s0.jpg"> </a>
				</li>
				<li><a href="/"><img src="resources/images/s2.jpg"> </a>
				</li>
				<li><a href="/"><img src="resources/images/s5.jpg"> </a>
				</li>
				<li><a href="/"><img src="resources/images/s6.jpg"> </a>
				</li>
				<li><a href="/"><img src="resources/images/s7.jpg"> </a>
				</li>
				<li><a href="/"><img src="resources/images/s8.jpg"> </a>
				</li>
			</ul>
		</div>
	</div>
	<div class="rightbox box">
		<h2>添加文章</h2>
		<s:form action="user/add_succArticle.action" theme="simple"
			validate="true" autocomplete="off">
		<center><s:textfield name="title"  cssStyle="font-size:20px; text-align:center;width:400px" placeholder="文章标题" /><br>
			<FCK:editor id="content" basePath="/models/fckeditor/"
                  height="70%"   
				imageBrowserURL="/FCKeditorhttp://oldblog.voc.com.cn/editor/filemanager/browser/default/browser.html?Type=Image&Connector=connectors/jsp/connector"
				flashBrowserURL="/FCKeditorhttp://oldblog.voc.com.cn/editor/filemanager/browser/default/browser.html?Type=Flash&Connector=connectors/jsp/connector"
				imageUploadURL="/FCKeditorhttp://oldblog.voc.com.cn/editor/filemanagerhttp://oldblog.voc.com.cn/upload/simpleuploader?Type=Image"
				linkUploadURL="/FCKeditorhttp://oldblog.voc.com.cn/editor/filemanagerhttp://oldblog.voc.com.cn/upload/simpleuploader?Type=File"
				flashUploadURL="/FCKeditorhttp://oldblog.voc.com.cn/editor/filemanagerhttp://oldblog.voc.com.cn/upload/simpleuploader?Type=Flash">
			</FCK:editor>
			<s:submit value="发表" cssStyle=" height: 35px;width: 70px;background-color:#0099FF;	border:hidden;#0033CC;border-radius:5px;" />
			&nbsp;&nbsp;&nbsp;
			<a href="user/listArticle.action">
			<input type="button" value="取消"	Style=" height: 35px;width: 70px;background-color:yellow;	border:hidden;#0033CC;border-radius:5px;" />
			</a></center>
		</s:form>
	</div>


	</div>
	<div class="blank"></div>
	<div class="Copyright">
		<ul>
			<a href="/">帮助中心</a>
			<a href="/">空间客服</a>
			<a href="/">投诉中心</a>
			<a href="/">空间协议</a>
		</ul>
		<p>Design by DanceSmile</p>
	</div>
	</article>
</body>
</html>
