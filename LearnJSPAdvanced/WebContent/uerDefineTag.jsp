<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib uri="showDateUri" prefix="wghDate" %>
<html>
  <head><title>�����Զ����ǩ��ʾ��ǰϵͳ����</title></head>
 <body>
������<wghDate:showDate/>
<% int num=6;
request.setAttribute("no",num);
%>
</body>
</html>
