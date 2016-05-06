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
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<sx:head debug="true" extraLocales="en-us,nl-nl,de-de" />
<title><s:property value="art.title" />
</title>

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
<script type="text/javascript" src="resources/js/jquery-1.7.1.js">
</script>
<script type="text/javascript">
		$(document).ready(function(){    
    $("#login").click(function(){    
        addCritique();    
        });    
});
function addCritique(){    
var url = "user/addCritique.action";    
var params = {"userName":document.getElementById("userName").value,
	"article_id":document.getElementById("article_id").value,
	"criticInfo":document.getElementById("criticInfo").value};    
	$.ajax({cache:false,url:'user/addCritique.action',type:'post',dataType:'json',data:{"userName":document.getElementById("userName").value,
	"article_id":document.getElementById("article_id").value,
	"criticInfo":document.getElementById("criticInfo").value},success:function callback(data){    
        // convert to json object    
        if(data == "true"){
    		alert("评论成功");
    	}else{
    		alert("评论失败");
    	}
    	showReview(1);
    	}
        });   
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
						<br /> <a href="${logoutUrl}" onclick="logout()">退出登录</a> <br />
						<a href="user/listArticle.action">博文目录</a> <br>
						<a href="user/addArticle.action">发表博文</a>
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
			<img src="resources/images/180.jpg" class="photo">
			<p class="fn">姓名：曾豪</p>
			<p class="nickname">兴趣：</p>
			<p class="url">职业：学生</p>
			<p class="address">专业：电子信息工程</p>
			<p class="role">现居：武汉市华科大</p>
		</div>
		<div class="blogclass box">
			<h2>博客分类</h2>
			<ul>
				<li><a href="/">java 面向对象(3)</a></li>
				<li><a href="/">spring(25)</a></li>
				<li><a href="/">>ssh 整合(39)</a></li>
			</ul>
		</div>
		<div class="blogclass box">
			<ul id="blog_statistics">
				<li>原创：<span>30篇</span>
				</li>
				<li>转载：<span>2篇</span>
				</li>
				<li>译文：<span>4篇</span>
				</li>
				<li>评论：<span>7条</span>
				</li>
			</ul>
		</div>
	</div>
	<div class="rightbox box">
		<h2>查看文章</h2>
		<center>
			<h1>
				<s:property value="art.title" />
			</h1>
		</center>
		<span class="link_categories"> &nbsp; &nbsp;<font color="gray">分类：</font>
			<a href="">【web开发学习笔记】</a> </span> <font
			style="position:absolute;right:250px;color:gray">发表时间：2014-07-07
			14:11&nbsp;&nbsp;719 人阅读 &nbsp;<a href="">评论&nbsp;(0)</a>&nbsp;<a
			href="">&nbsp;收藏(3)</a> </font>
		<s:set var="content" value="art.content" />
		${content } <br> <a href="">&nbsp;&nbsp;<font size="4px">上一篇:</font>
		</a> <br> <a href=""> &nbsp;&nbsp;<font size="4px">下一篇:</font> </a> <span
			style="position:absolute;right:250px;font-size:17px"><a
			href="">点赞&nbsp;(3)&nbsp;</a>&nbsp;<a href="">&nbsp;转载</a> </span>
	</div>
	<div class="rightbox box">
		<h2>
			<input type="button" value="查看评论" onclick="showReview(1)">
		</h2>
	</div>
	<s:debug></s:debug> <script type="text/javascript">
function showReview(pageNow){
	var url = "user/showCritique.action";    
var params = {"pageNow":pageNow};    
   $.getJSON(url,params,function callback(data){    
        // convert to json object    
   	var critique = eval("("+data.json+")");//
	//var pa = eval("("+data.page+")");
  	var str= "";
  	 $("#review").empty();
  	if(critique.length == 0){
  		str="<font color=\"red\" size=\"4px\">暂无评论</font>";
  	}else{
  		for(var i=0;i<critique.length;i++){
  			 $("#review").append("<h2 size=\"2px\">回复：(title)  "+critique[i].critic_date+" | XXX</h2 ><br><font size=\"3px\">"+critique[i].criticInfo+"</font>"+
  			 " <br /><br />");
  		} 
  		var pageNext = data.page.pageNow < data.page.totalPage? data.page.pageNow + 1 : data.page.totalPage;
  		var pageLast =  data.page.pageNow > 1 ? data.page.pageNow - 1 : 1;
  		 $("#review").append("<center>共 "+data.page.pageNow+" 页 &nbsp;&nbsp;当前第 "+
						+data.page.pageNow+" 页&nbsp;&nbsp; 共 "+data.page.totalSize+" 条记录&nbsp;&nbsp;<a onclick=\"showReview("+1+")\"\">首页</a> "+
						"<a onclick=\"showReview("+pageLast+")\"\">上一页</a>"+
						"<a onclick=\"showReview("+pageNext+")\"\">&nbsp;&nbsp;下一页</a>"+
						"<a onclick=\"showReview("+data.page.totalPage+")\">&nbsp;&nbsp;尾页</a></center>");
		}
	        });    
}
</script>
	<div class="rightbox box">
		<center>
			<h1>评论内容：</h1>
		</center>
		<div id="review"></div>
	</div>
	<div class="rightbox box">
		<h2>发表评论</h2>
		<font size="3px">用户名： <security:authentication property="name" />
		</font><br>
		<s:form id="criform" theme="simple">
			<!-- action="user/addCritique.action" -->
			<s:hidden name="article_id" value="%{art.id}" id="article_id" />
			<input type="hidden" id="userName" name="userName"
				value="<security:authentication property="name" />" />
			<font size="3px">评论内容：</font>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:textarea name="criticInfo" id="criticInfo"
				cssStyle="width:400px;height:200px"></s:textarea>
			<br>
			<div style="margin-left:200px">
				<input type="button" id="login" value="评论"
					Style=" height: 35px;width: 70px;background-color:#0099FF;	border:hidden;#0033CC;border-radius:5px;" />&nbsp;&nbsp;&nbsp;&nbsp;
				<s:reset value="重置"
					cssStyle=" height: 35px;width: 70px;background-color:yellow;	border:hidden;#0033CC;border-radius:5px;" />
			</div>
		</s:form>
	</div>
	<div class="clear"></div>
	<div class="blank">test3</div>
	<div class="Copyright" style="position:absolute; left:550px;">
		<a href="#">帮助中心</a> <a href="#">空间客服</a> <a href="#">投诉中心</a> <a
			href="#">空间协议</a>
		<p>Design by DanceSmile</p>
	</div>
	</article>

</body>
</html>
