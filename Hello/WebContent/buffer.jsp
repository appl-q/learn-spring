<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>������</title>
</head>

<body>
<%
out.print("��������С��"+response.getBufferSize()+"<br>");
out.print("����������ǿ���ύǰ<br>");
out.print("��������Ƿ��ύ��"+response.isCommitted()+"<br>");
response.flushBuffer();
out.print("����������ǿ���ύ��<br>");
out.print("��������Ƿ��ύ��"+response.isCommitted()+"<br>");
%>

</body>
</html>
