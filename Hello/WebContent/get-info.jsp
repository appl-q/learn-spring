<%@page import="java.util.Locale"%>
<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>��ȡ�ͻ���Ϣ</title>
</head>
<body>
<p>�ͻ��ύ��Ϣ�ķ�ʽ��<%=request.getMethod()%></p>
<p>ʹ�õ�Э�飺<%=request.getProtocol()%></p>
<p>��ȡ���������ַ����Ŀͻ��˵�ַ��<%=request.getRequestURI()%></p>
<p>��ȡ�ύ���ݵĿͻ���IP��ַ��<%=request.getRemoteAddr()%></p>
<p>��ȡ�������˿ںţ�<%=request.getServerPort()%></p>
<p>��ȡ�����������ƣ�<%=request.getServerName()%></p>
<p>��ȡ�ͻ��˵Ļ������ƣ�<%=request.getRemoteHost()%></p>
<p>��ȡ�ͻ���������Ľű��ļ����ļ�·��:<%=request.getServletPath()%></p>
<p>���HttpЭ�鶨����ļ�ͷ��ϢHost��ֵ:<%=request.getHeader("host")%></p>

<!-- �жϵ�ǰ�����Ƿ�ʹ����һ������HTTP�İ�ȫЭ�� -->
<p>�û���ȫ��Ϣ:<%=request.isSecure()%></p>

<%
Locale locale = request.getLocale();
if(locale.equals(Locale.US)) {
	out.print("Welcome to Beijing!");
} else if(locale.equals(locale.CHINA)) {
	out.print("������ӭ�㣡");
}

%>

</body>
</html>
