<%@ page contentType="text/html; charset=gb2312" language="java"%>
<jsp:useBean id="upFile" scope="page" class="com.jspsmart.upload.SmartUpload" />
<%
try{
	response.reset();
	out.clear();
	out=pageContext.pushBody();
	upFile.initialize(pageContext);
	upFile.setContentDisposition(null);
	String file="/upload/"+request.getParameter("filename");
	upFile.downloadFile(file);
}catch(Exception e){
	out.println("<script>alert('�ļ�����ʧ�ܣ�����ѡ����ļ��Ƿ���ڣ�')</script>");
}
%>