<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>����&lt;c:if&gt;��ǩ</title>
</head>
  
<body>

�﷨һ������û����Ƿ�Ϊnull<br>
<c:if test="${param.user==null}" var="rtn" scope="page"/>
<c:out value="${rtn}"/><br>

�﷨��������û���Ϊ�գ������һ�����������û������ı��򼰡��ύ����ť<br>
<c:if test="${param.user==null}">
	<form action="" method="post">
		�������û�����<input type="text" name="user">
		<input type="submit" value="�ύ">
	</form>
</c:if>

</body>
</html>
