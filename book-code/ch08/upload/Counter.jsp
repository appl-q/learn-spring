<%@ page contentType="text/html; charset=gb2312" %>
<%@ page language="java" %>
<%
  Integer count = null; 
  //ͬ������
  synchronized (application)
  {
    //���ڴ浱�ж�ȡ������
    count = (Integer) application.getAttribute("basic.counter"); 
    if (count == null) 
    count = new Integer(0); 
    count = new Integer(count.intValue() + 1);
    //�����������浽�ڴ浱��
    application.setAttribute("basic.counter", count);
  }
%>
<html>
<head>
<title>�򵥼�����</title>
</head> 
<body> 
<center>
<font size=10 color=blue>�򵥼�����</font>
<br>
<hr>
<br>
<font size=5 color=blue>���ã����Ǳ�վ�ĵ� <%= count %> λ����</font>
</center>
</body> 
</html>
