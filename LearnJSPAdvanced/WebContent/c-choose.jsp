<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>����&lt;c:choose&gt;��ǩ</title>
  </head>
  
  <body>
<c:set var="hours">
	<%=new java.util.Date().getHours()%>
</c:set>
<c:choose>
	<c:when test="${hours>6 && hours<11}" >����ã�</c:when>
	<c:when test="${hours>11 && hours<17}">����ã�</c:when>
	<c:otherwise>���Ϻã�</c:otherwise>
</c:choose>
 ����ʱ���ǣ�${hours}ʱ 
  </body>
</html>
