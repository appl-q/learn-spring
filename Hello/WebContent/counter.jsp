<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>������</title>
</head>

<body>

<% 
int number=0;
if(application.getAttribute("number")==null){
	number=1;
}else{
	number=Integer.parseInt((String)application.getAttribute("number"));
	number=number+1;
}

out.print("���ǵ�"+number+"λ�����ߣ�");
application.setAttribute("number",String.valueOf(number));

out.print(application.getAttribute("number").getClass()); // class java.lang.String 
%>

</body>
</html>
