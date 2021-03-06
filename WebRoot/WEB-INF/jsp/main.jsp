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
<script type="text/javascript">
	function logout() {
		alert("退出成功！");
	}
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
						<br><a href="user/chat_in.action">聊天窗体</a>
						<br><a href="user/contact_in.action">聊天实现界面</a>
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
		<h2>最新博文</h2>
		<h3 class="title">
		
			<a href="#"></a>
		</h3>
		<h3 class="title">
			<a href="/">陌上花开，可缓缓归矣</a>
		</h3>
		<ul class="text">
			<p>“陌上花开，可缓缓归矣。” 含义：（夫人），田间阡陌上的花开了，你可以一边赏花，一边慢慢地回来。</p>
			<p>“陌上花开，如果没有悄然伫立阡陌并为陌上风情所陶醉的人，那么花开也寂寞，风情也苍白....”喜欢这句话，是因为看了忍冬的作品《陌上花开缓缓归》</p>
			<p>阳春三月，风和日暖，信步城外，看阡陌之上的杨柳依依，野花绚烂，身心不由得轻爽而浪漫。“三月风情陌上花”，古远的诗句似乎随风从天边飘来，从历史的深处飘来，拂过阡陌，袭上心头，诗是属于清乾嘉诗人赵翼的，可昂首远望，眼前的陌上风情却是不折不扣的现代，由眼帘入心扉。</p>
			<p class="textimg">
				<img src="resources/images/tezt02.jpg">
			</p>
			<p>漫步陌上，心情是诗意的那种，优雅而散淡，不惹匆促，只因陌上花开；花是自然的那种，朴素而恬淡，不落尘俗。“三月风情陌上花”，是花在其中生命得以璀璨，人在其中心情得以畅然的一种意境。三月陌上花，让人爱让人痴，恍惚人的骨子里头都沉淀了花的影子，花的风韵。</p>
			<p>陌上花开，如果没有了从俗累的生活中走出来，悄然伫立阡陌并为陌上风情所陶醉的人，那么花开也寂寞，风情也苍白。于是，一句“陌上花开，可缓缓归矣”不知被多少人吟诵了多少遍。人归缓缓，那花便有灵性，便开得执著，陌上风情也被撩拨得浓郁而热烈。</p>
			<p>缓缓归，缓缓归，披一袭“三月风情”，再采一束“陌上花”，缓缓归。</p>
			<p>缓缓归矣，我心已是陌上花开。</p>
		</ul>
		<div class="textfoot">
			<a href="/">赞（13）</a><a href="/">阅读全文</a><a href="/">评论</a><a
				href="/">转载</a>
		</div>
		<h3 class="title">
			<a href="/">岁月留痕——我的2010</a>
		</h3>
		<ul class="text">
			<p>A面——岁月留痕之时光</p>
			<p>每逢新旧年交替时候，我就被笼罩在一股茫然的思绪里，逃也逃不脱，避也避不开，唯有让心事在静静流逝的时光里苍茫成河。</p>
			<p>是从什么时候开始的呢，我又变得如此感时伤怀？我很羡慕那些在年终盘点总结的人们，过去的一年于他们来说，是大刀阔斧的一年，是硕果累累的一年。再不济的话，也是豪情万丈的一年。而在我那逝去的时光里，平静如水，不起一丝波澜，一年又一年。我没有盘点，因为我没有波澜壮阔；我不会去总结，因为我的总结从来就没有逼近我的心灵。我知道这于我来说，显得多么无厘头。</p>
			<p class="textimg">
				<img src="resources/images/text01.jpg">
			</p>
			<p>我喜欢这样安静地坐下来，想一些似有若无的心事。尽量不去想那些飞逝的时光，尽量不去想那些形色匆忙的脚步，似乎是在害怕，在这高速运转的时空里，自己有一天会化作一堆虚无。还记得那一部《岁月神偷》的电影吗？真是要感谢来自香港的导演罗启锐，影片给我们芸芸众生留下太多的唏嘘。在如水一般逝去的时光里，皱纹爬上你的眼角，白发蔓延我的双鬓。岁月才是最好的神偷，偷走了我的青春和你的美好。</p>
			<p>就任这时光慢慢流淌吧，对于大多数人来说，我们无非就是浩瀚时空的一些微尘。虎年走了又怎样</p>
		</ul>
		<div class="textfoot">
			<a href="/">赞（17）</a> <a href="/">阅读全文</a><a href="/">评论</a><a
				href="/">转载</a>
		</div>
		<div class="pages">
			<span>1</span><a href="/" hidefocus="">2</a><a href="/" hidefocus="">3</a><a
				href="/" class="next">下一页&gt;&gt;</a>
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
