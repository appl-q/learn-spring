<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<%
if(request.getParameter("submit1")!=null){
	response.setContentType("application/msword;charset=gb2312");
}
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>����Ϊword</title>
</head>
<body>
ƽƽ���������棡
������ֲ��Ǹ���
<form action="" method="post" name="form1">
	<input name="submit1" type="submit" id="submit1" value="����Ϊword" /></input>
</form>

</body>
</html>
