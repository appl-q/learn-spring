<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>����&lt;c:removet&gt;��ǩ</title>
</head>
  
<body>

<c:set var="name" value="���������" scope="page"/>
�Ƴ�ǰ����ı���nameΪ��<c:out value="${name}"></c:out>

<c:remove var="name"/><br>

�Ƴ�������ı���nameΪ��<c:out value="${name}" default="����nameΪ��"></c:out>

</body>
</html>
