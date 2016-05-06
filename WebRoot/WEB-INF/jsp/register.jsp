<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<sx:head debug="true" extraLocales="en-us,nl-nl,de-de" />
<title>注册页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="resources/css/styles.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<script language="javascript">
	var checkuserName = function(value)
	{
		alert();
	};
	var xmlHttp;
	var flag = true;
	function createXMLHttp() {
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	function checkUserid(userName) {
		createXMLHttp();
		xmlHttp.open("POST", "user/checkUser!checkUser.action?userName=" + userName);
		xmlHttp.onreadystatechange = checkUseridCallback1;
		xmlHttp.send(null);
		document.getElementById("msg").innerHTML = "正在验证...";
	}
	function checkUseridCallback1() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {

				var text = xmlHttp.responseText;
				alert(text);
				if (text == "true") { // 用户id已经存在了
					document.getElementById("msg").innerHTML = "该用户已被注册";
					flag = false;
				} else {
					document.getElementById("msg").innerHTML = "该用户可以注册！";
					flag = true;
				}
			}
		}
	}
</script>
<body>
	<article> <header>
	<div class="toptitle">
		<h1>谁的青春，蹀躞徘徊</h1>
		<p class="byline">——消逝的年华</p>
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
			<center>
				<h2>
					返回<a href="free/login.action">登录界面</a>
				</h2>
			</center>
		</div>
		<div class="blogclass box">test1</div>
	</div>
	<div class="rightbox box">
		<div id="container">
			<div id="content">
				<div id="col_left">
					<div class="post">
						<div class="meta"></div>
						<div class="comments">
							<div class="comment"></div>
							<center>
								<h2 style="font-size:30px">新博客注册</h2>
							</center>
							<div style="position:relative; margin-left:70px;">
								<div style="position:relative margin:10 0 20 0 ">
								<span id="msg" style="color:red;font-size:15"></span>
									<s:form action="user/addUser.action" theme="simple"
										validate="true" autocomplete="off" >
										<br /> &nbsp;&nbsp;&nbsp;<label>账&nbsp;&nbsp;号：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:textfield name="userName"  /> <!-- onblur="checkUserid(this.value)"  -->
										<font color="red"><s:property value="errors.userName[0]" />
										</font>
										<br>
										<br>
										&nbsp;&nbsp;&nbsp;<label>密&nbsp;&nbsp;码：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:password name="password"/>
										<font color="red"><s:property value="errors.password[0]"/></font>
										<br>
										<br> &nbsp;&nbsp;&nbsp;<label>确认密码：</label>
										<s:password name="password1"  />
										<br>
										<br>
										&nbsp;&nbsp;&nbsp;<label>邮&nbsp;&nbsp;箱：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:textfield name="email"  />
											<font color="red"><s:property value="errors.email[0]"/></font>
										<br>
										<br> &nbsp;&nbsp;&nbsp;<label>昵&nbsp;&nbsp;称：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:textfield name="name" /><font color="red"><s:property value="errors.name[0]"/></font>
										<br>
										<br> &nbsp;&nbsp;&nbsp;<label>性&nbsp;&nbsp;别：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:radio list="#{'男':'男','女':'女'}" name="gender" value="'男'" />
										<br>
										<br>
										<label>密码保护问题：</label>
										<s:select name="question"
											list="{'你的母亲的名字是？',
										'你的生日是多少？','你最喜欢的颜色是？','你的工作是什么？'}" />
										<br>
										<br>
										<label> 密码保护答案：</label>
										<s:textfield name="answer" />
										<br>
										<br>
										<center>
											<s:submit value="注册"
												cssStyle=" height: 35px;width: 70px;background-color:#0099FF;	border:hidden;#0033CC;border-radius:5px;" />
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<s:reset value="重置"
												cssStyle=" height: 35px;width: 70px;background-color:yellow;	border:hidden;#0033CC;border-radius:5px;" />
											<br> <br>
										</center>
									</s:form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="blank">test3</div>
	<div class="Copyright" style="position:absolute; left:550px;">
		<ul>
			<a href="#">帮助中心</a>
			<a href="#">空间客服</a>
			<a href="#">投诉中心</a>
			<a href="#">空间协议</a>
		</ul>
		<p>Design by DanceSmile</p>
	</div>
	</article>

</body>
</html>
