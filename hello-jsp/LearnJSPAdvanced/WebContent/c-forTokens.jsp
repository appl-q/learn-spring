<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>����&lt;c:forTokens&gt;��ǩ</title>
  </head>
  
  <body>
<c:set var="sourceStr" value="����|����|wgh|��|simpleRain"/>
ԭ�ַ�����<c:out value="${sourceStr}"/>
<br>�ָ����ַ�����
<c:forTokens var="str" items="${sourceStr}" delims="|" varStatus="status">
	<c:out value="${str}"></c:out> �� 
	<c:if test="${status.last}">
		<br>�ܹ����<c:out value="${status.count}"></c:out>��Ԫ�ء�
	</c:if>
</c:forTokens>

  </body>
</html>
