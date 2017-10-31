<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#main{
			position:fixed;
  			width: 400px;
  			height: 300px;
  			top:100%;
  			left:50%;
  			margin-top: -300px;
  			margin-left:-200px;
		}
		td{
			padding: 5px;
			
		}
		input{
			width:100%;
			height:30px;
		}
	</style>
  </head>
  
  <body>
  <form action="LoginServlet" method="post">
   <div id="main">
    	<center><h3>用户登录</h3></center>
    	<table>
    		<tr>
    			<td width="66" align="right"><font size="3">帐&nbsp;&nbsp;号：</font></td>
    			<td colspan="2"><input type="text" name="username"/></td>
    			<td><font color="red" size="2"> ${msg2 }</font></td>
    		</tr>
    		<tr>
				<td align="right"><font size="3">密&nbsp;&nbsp;码：</font></td>
				<td colspan="2"><input type="password" name="password" /></td>
				<td><font color="red" size="2"> ${msg3 }</font></td>
    		</tr>
    		<tr>
    			<td align="right"><font size="3">验证码：</font></td>
    			<td width="110px" valign="middle"><input type="text" name="verifycode" /></td>
    			<td width="90px" valign="middle"><img src="VerifyCodeServlet" id="verify" onclick="document.getElementById('verify').src='VerifyCodeServlet?'+Math.random();"></td>
    			<td><font color="red" size="2"> ${msg1 }</font></td>
    		</tr>
    		<tr>
    			<td>&nbsp;</td>
    			<td colspan="2" align="center"><input type="submit" value="登录" /></td>
    		</tr>
    	</table>
     </form>
    <a href="regist.jsp" style="margin-left: 80px;"><font size="2"><i>注册账号</i></font></a>
  </div>
  </body>
</html>
 