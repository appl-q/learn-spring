<%@page contentType="text/html;charset=gb2312" %>

<%
	String name=request.getParameter("userName");	  	//��ȡ����userName�ֶ�ֵ
	if(name==null)name="";
	String password=request.getParameter("userPass");	//��ȡ����userPass�ֶ�ֵ
	if(password==null)password="";
%>
<center>
	<b>�û�����</b><%=name %>								<!-- ����û��� -->
	<b>���룺</b><%=password %>							<!-- ������� -->
</center>

<p>
<a href="index.jsp">��������</a>
