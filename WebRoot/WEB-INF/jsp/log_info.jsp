<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script type="text/javascript" src="resources/js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
</head>
<script type="text/javascript">
	
</script>
<body onload="hide1(),hide2(),hide3();">
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<h1 class="topbar-logo none">
					<a href="index" class="navbar-brand">后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on" href="user/main">首页</a>
					</li>
					<li><a href="main.jsp" target="_blank">管理界面首页</a>
					</li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li>
						<form name="form1" action="user/loglist.action" method='GET'>
							<input type="hidden" name="pageNow" value="1" /> <input
								type="hidden" name="orderType" value="id" /> <input
								type="hidden" name="sortInverse" value="1" /> <a
								href="javascript:document.form1.submit();">用户管理界面</a>
						</form></li>
					<li><a href="user/main.html">博客主页</a>
					</li>
					<c:url value="/logout" var="logoutUrl" />
					<li><a href="${logoutUrl}" onclick="logout()">退出登录</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><i class="icon-font">&#xe003;</i>常用操作
						<ul class="sub-menu">
							<li><a href="design"><i class="icon-font">&#xe005;</i>博文管理</a>
							</li>
							<li><a href="design"><i class="icon-font">&#xe006;</i>分类管理</a>
							</li>
							<li><a href="design"><i class="icon-font">&#xe004;</i>留言管理</a>
							</li>
							<li><a href="design"><i class="icon-font">&#xe012;</i>评论管理</a>
							</li>
							<li><a href="user_manager.jsp"><i class="icon-font">&#xe052;</i>用户管理</a>
							</li>
						</ul></li>
					<li><i class="icon-font">&#xe018;</i>系统管理
						<ul class="sub-menu">
							<li><a href="user/loglist.action?pageNow=1&orderType=id&sortInverse=1"><i class="icon-font">&#xe017;</i>日志记录</a>
							</li>
							<li><a href="system"><i class="icon-font">&#xe037;</i>清理缓存</a>
							</li>
							<li><a href="system"><i class="icon-font">&#xe046;</i>数据备份</a>
							</li>
							<li><a href="system"><i class="icon-font">&#xe045;</i>数据还原</a>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!--/sidebar-->

		<div class="main-wrap">

			<div style="position:absolute;right:10px; top:60px">
				<font color="green">您好， <security:authentication
						property="name" /> </font> <font color="brown">,用户权限： </font>
				<security:authentication property="authorities" var="authorities" />
				<c:forEach items="${authorities}" var="authority" varStatus="color">
					<c:if test="${color.count%2==1}">
						<font style="color:blue">${authority.authority}</font>
					</c:if>
					<c:if test="${color.count%2==0}">
						<font style="color:red">${authority.authority}</font>
					</c:if>
				</c:forEach>
			</div>
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="#">首页</a><span
						class="crumb-step"> &gt;</span><span class="crumb-name">用户管理</span>
				</div>

			</div>
			<div class="search-wrap">
				<div style="font-size:15px;color:brown">

					<center>
						查询类型:
						<form style="display:inline;">
							<select size="1" name="pageNow" style=" height: 18"
								onchange="submitForm1()" id="search">
								<option>选择类型</option>
								<option value="simpleSearch">简单查询</option>
								<option value="advancedSearch">高级查询</option>
							</select>
						</form>
					</center>
				</div>
			</div>

			<div class="search-wrap">
				<div id="wrapper1">
					<div class="search-content">
						<form action="user/search.html" method="post">
							<table class="search-tab">
								<tr>
									<th width="120">简单查询:</th>
									<td><input type=radio name=SearchType value="vague">模糊查找
										<input type=radio name=SearchType value="accurate" checked>精确查找
										<input type="hidden" name="pageNow" value="1" />
									</td>
									<th width="70"><select name="informationType">
											<option value="userName">账号</option>
											<option value="name">名称</option>
											<option value="id">编号</option>
											<option value="gender">性别</option>
									</select>
									</th>
									<td><input class="common-text" placeholder="关键字"
										name="keywords" type="text"></td>
									<td><input class="btn btn-primary btn2" name="sub"
										value="查询" type="submit"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div id="wrapper2">
					<div class="search-content">
						<form action="user/advancedSearch.html" method="post">
							<table class="search-tab">
								<tr>
									<th width="120">高级查询:</th>
									<input type="hidden" name="pageNow" value="1" />
									<td><label>名称:&nbsp</label><input class="common-text"
										placeholder="名称" name="name" type="text"></td>
									<td><label>账号:&nbsp</label><input class="common-text"
										placeholder="账号" name="userName" type="text"></td>
									<td><label>性别:&nbsp</label> <input type="radio"
										name="gender" value="男" checked />男 <input type="radio"
										name="gender" value="女" />女</td>
									<td><label>邮箱:&nbsp</label><input class="common-text"
										placeholder="邮箱" name="email" type="text"></td>
									<td><input class="btn btn-primary btn2" name="sub"
										value="查询" type="submit"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<div class="result-list">
						<a href="#"><i class="icon-font"></i>新增用户</a> <a id="batchDel"
							onclick="document.getElementsByName(checkall).checked"><i
							class="icon-font"></i>批量删除</a> <a id="updateOrd"
							href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
					</div>
				</div>
				<div class="result-content">
					<table class="result-tab" width="100%">
						<tr>
							<th class="tc" width="5%"><input class="allChoose" name=""
								type="checkbox"></th>
							<th><center>
									<a
										href="user/loglist.action?pageNow=1&orderType=id&sortInverse=${sortInverse+1}">序号</a>
								</center></th>
							<th><center>
									<a
										href="user/loglist.action?pageNow=1&orderType=userName&sortInverse=${sortInverse+1}">账号</a>
								</center></th>
							<th><center>
									<a
										href="user/loglist.action?pageNow=1&orderType=operDesc&sortInverse=${sortInverse+1}">操作描述</a>
								</center></th>
							<th><center>
									<a
										href="user/loglist.action?pageNow=1&orderType=operStatus&sortInverse=${sortInverse+1}">操作状态</a>
								</center></th>
							<th><center>
									<a
										href="user/loglist.action?pageNow=1&orderType=operPara&sortInverse=${sortInverse+1}">操作参数</a>
								</center></th>
							<th><center>
									<a
										href="user/loglist.action?pageNow=1&orderType=operTime&sortInverse=${sortInverse+1}">操作时间</a>
								</center></th>
							<th><center>
									<a
										href="user/loglist.action?pageNow=1&orderType=operaIP&sortInverse=${sortInverse+1}">IP地址</a>
								</center></th>
						</tr>
						<c:set var="page" value="${page}" />
						<c:forEach var="user" varStatus="status" items="${log}">
							<c:if test="${status.count%2==1}">
								<tr style="background-color:#F7FFFF">
							</c:if>
							<c:if test="${status.count%2==0}">
								<tr style="background-color:white">
							</c:if>
							<td class="tc"><input name="checkall" 
								type="checkbox" width="2%"></td>
							<td width="4%"><center>
									<input class="common-input sort-input" name="ord[]"
										value="${user.id}" type="text">
								</center></td>
							<td width="10%"><c:out value="${user.userName}" /></td>
							<td width="10%"><c:out value="${user.operDesc}" /></td>
							<td width="10%"><c:out value="${user.operStatus}" /></td>
							<td width="10%"><c:out value="${user.operPara}" /></td>
							<td width="10%"><c:out value="${user.operTime}" /></td>
							<td width="10%">&nbsp;<c:out value="${user.operaIP}" /></td>
							</tr>
						</c:forEach>
					</table>

					<center>
						<font size="2">共</font>
						<c:out value="${page.totalPage}" />
						<font size="2">页 &nbsp;&nbsp;当前第</font>
						<c:out value="${page.pageNow}" />
						<font size="2">页&nbsp;&nbsp; 共</font>
						<c:out value="${page.totalSize}" />
						<font size="2">条记录&nbsp;&nbsp; <!-- 首页始终显示第一页 --> <a
							href="user/loglist.action?pageNow=1&orderType=${orderType}&sortInverse=${sortInverse}">首页</a>
							<!-- 如果有前一页就提交前一页的pageNow值 --> <c:choose>
								<c:when test="${page.hasPre}">
									<a
										href="user/loglist.action?pageNow=${page.pageNow-1}&orderType=${orderType}&sortInverse=${sortInverse}">上一页</a>
								</c:when>
								<c:otherwise>
									<a
										href="user/loglist.action?pageNow=1&orderType=${orderType}&sortInverse=${sortInverse}">上一页</a>
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${page.hasNext}">
									<a
										href="user/loglist.action?pageNow=${page.pageNow+1}&orderType=${orderType}&sortInverse=${sortInverse}">下一页</a>
								</c:when>
								<c:otherwise>
									<a
										href="user/loglist.action?pageNow=${page.totalPage}&orderType=${orderType}&sortInverse=${sortInverse}">下一页</a>
								</c:otherwise>
							</c:choose> <!-- 尾页始终提交最后一页的pageNow值 --> <a
							href="user/loglist.action?pageNow=${page.totalPage}&orderType=${orderType}&sortInverse=${sortInverse}">尾页</a>
							&nbsp;跳转到: </font>
						<form name="myForm" action="user/loglist.action" method="get"
							style="display:inline;">
							<select size="1" name="pageNow" style=" height: 18"
								onchange="submitForm()">
								<c:forEach begin="1" end="${page.totalPage}" varStatus="status">
									<option value="${status.index}"
										$
								{status.index==page.pageNow?'selected' : ''}>${status.index}</option>
								</c:forEach>
							</select> <input type="hidden" name="pageNow" value="1" /> <input
								type="hidden" name="orderType" value="${orderType}" /> <input
								type="hidden" name="sortInverse" value="${sortInverse}" />
						</form>
					</center>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var wrapper1 = document.getElementById("wrapper1");
		var wrapper2 = document.getElementById("wrapper2");
		var wrapper3 = document.getElementsById("wrapper3");
		function show1() {
			wrapper1.style.display = "block";
		}
		function hide1() {
			wrapper1.style.display = "none";
		}
		function show2() {
			wrapper2.style.display = "block";
		}
		function hide2() {
			wrapper2.style.display = "none";
		}
		function show3() {
			wrapper3.style.display = "block";
		}
		function hide3() {
			wrapper3.style.display = "none";
		}
		function submitForm() {
			var frm = document.myForm;
			frm.submit();
		}
		function submitForm1() {
			if (document.getElementById("search").value == "simpleSearch") {
				show1();
				hide2();
			} else if (document.getElementById("search").value == "advancedSearch") {
				show2();
				hide1();
			} else {
				hide1();
				hide2();
			}
		}
		$(document).ready(function() {
			$(".list_tb tr").mouseover(function() {
				$(this).addClass("highlight");
			}).mouseout(function() {
				$(this).removeClass("highlight");
			})
		});

		var xmlHttp;
		var flag = false;
		function createXMLHttp() {
			if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			} else {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}

		function showoffMsg(id) {
			createXMLHttp(); //创建XMLHttp对象
			xmlHttp.open("POST", "user/detailOffer.html?timeStamp="
					+ new Date().getTime(), true);
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xmlHttp.send("id=" + id);
			xmlHttp.onreadystatechange = showMsgCallback;
		}
		function showreqMsg(id) {
			createXMLHttp(); //创建XMLHttp对象
			xmlHttp.open("POST", "user/detailRequire.html?timeStamp="
					+ new Date().getTime(), true);
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xmlHttp.send("id=" + id);
			xmlHttp.onreadystatechange = showMsgCallback;
		}
		function showMsgCallback() {//回调操作函数
			if (xmlHttp.readyState == 4) {//调用完成
				if (xmlHttp.status == 200) {//HTTP状态码操作正常
					var text = xmlHttp.responseText;
					var data = eval("(" + text + ")");
					document.getElementById("userName_info").innerHTML = data.userName;
					document.getElementById("name_info").innerHTML = data.name;
					document.getElementById("remarks_info").innerHTML = data.remarks;
					show();
				}
			}
		}
		function logout() {
			alert("成功退出！");
		}
	</script>
</body>
</html>
