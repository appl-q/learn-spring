<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="valuebean.WordSingle" %>

<%
	ArrayList wordlist=(ArrayList)application.getAttribute("wordlist");
	if(wordlist==null || wordlist.size()==0) {
		out.print("û�����Կ���ʾ��");
	}
	else {
		for(int i=wordlist.size()-1;i>=0;i--) {
			WordSingle single=(WordSingle)wordlist.get(i);
%>
	�� �� �ߣ�<%=single.getAuthor() %>
	<p>
	����ʱ�䣺<%=single.getTime() %>
	<p>
	���Ա��⣺<%=single.getTitle() %>
	<p>
	�������ݣ�
	<textarea rows="7"  cols="30" readonly><%=single.getContent() %></textarea>
	
	<a href="index.jsp">��Ҫ����</a>
	<hr width="100%">
<%
		}
	}
%>
