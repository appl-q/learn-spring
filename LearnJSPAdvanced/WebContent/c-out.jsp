<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>����&lt;c:out&gt;��ǩ</title>
</head>
  
<body>
<!-- escapeXml �Ƿ�ת�� < -->
escapeXml����ֵΪfalseʱ��<c:out value="<hr>" escapeXml="false"/>

escapeXml����ֵΪtrueʱ��<c:out value="<hr>"/><br>
��һ���﷨��ʽ��<c:out value="${name}" default="name��ֵΪ��"/><br>

�ڶ����﷨��ʽ��<c:out value="${name}">name��ֵΪ��</c:out>
   
</body>
</html>
