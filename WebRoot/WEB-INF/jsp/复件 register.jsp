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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

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
		xmlHttp.open("POST", "user/checkUserName.html?userName=" + userName);
		xmlHttp.onreadystatechange = checkUseridCallback1;
		xmlHttp.send(null);
		document.getElementById("msg").innerHTML = "正在验证...";
	}
	function checkUseridCallback1() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {

				var text = xmlHttp.responseText;
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
	function checksame() {
		if (document.getElementById("password1").value != document
				.getElementById("password").value) {
			document.getElementById("msg").innerHTML = "两次输入密码不一致！";
			flag = false;
		} else {
			document.getElementById("msg").innerHTML = "";
			falg = true;
		}
	}

	function checkForm() {
		return flag;
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
					返回<a href="user/tologin.html">登录界面</a>
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
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
										id="msg" style="color:red;font-size:20px"></span>
									<form action="user/addUser.action" method="post">
										<br /> &nbsp;&nbsp;&nbsp;<label class="size">账&nbsp;&nbsp;号：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="text" name="userName" class="size"
											onblur="checkUserid(this.value)">
										<s:fielderror fieldName="userName" />
										<br> <br> &nbsp;&nbsp;&nbsp;<label class="size">密&nbsp;&nbsp;码：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="password" name="password" id="password"
											class="size">
										<s:fielderror fieldName="password" />
										<br> <br> &nbsp;&nbsp;&nbsp;<label class="size">确认密码：</label>
										<input type="password" name="password1" id="password1"
											class="size" onblur="checksame()"> <br> <br>
										&nbsp;&nbsp;&nbsp;<label class="size">邮&nbsp;&nbsp;箱：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="text" name="email" class="size">
										<s:fielderror fieldName="email" />
										<br> <br> &nbsp;&nbsp;&nbsp;<label class="size">昵&nbsp;&nbsp;称：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="text" name="name" class="size"> <br>
										<br> &nbsp;&nbsp;&nbsp;<label class="size">性&nbsp;&nbsp;别：</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" name="gender" value="男" checked="checked"
											class="size" /> <label Class="size">男</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" name="gender" value="女" class="size" /> <label
											Class="size">女</label> <br> <br> <label
											class="size">密码保护问题：</label> <select name="question"
											class="size">
											<option value="你的父亲的名字是？">你的父亲的名字是？&nbsp; &nbsp;</option>
											<option value="你的母亲的名字是？">你的母亲的名字是？</option>
											<option value="你的生日是多少？">你的生日是多少？</option>
											<option value="你最喜欢的颜色是？">你最喜欢的颜色是？</option>
											<option value="你的工作是什么？">你的工作是什么？</option>
										</select> <br> <br> <label class="size">密码保护答案：</label> <input
											type="text" name="answer" class="size" /> <br> <br>
										<center>
											<input type="submit" value="注册"
												style=" height: 35px;width: 70px;background-color:#0099FF;	border:hidden;#0033CC;border-radius:5px;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="reset" value="重置"
												style=" height: 35px;width: 70px;background-color:yellow;	border:hidden;#0033CC;border-radius:5px;" /><br>
											<br>
										</center>
									</form>
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
