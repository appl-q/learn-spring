<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="valuebean.GoodsSingle" %>
<%
	//��ȡ�洢��session�������洢�û��ѹ�����Ʒ��buylist���϶���
	ArrayList buylist=(ArrayList)session.getAttribute("buylist");
	float total=0; 							//�����洢Ӧ�����
%>
<table border="1" width="450" rules="none" cellspacing="0" cellpadding="0">
	<tr height="50"><td colspan="5" align="center">�������Ʒ����</td></tr>
	<tr align="center" height="30" bgcolor="lightgrey">
		<td width="25%">����</td>
		<td>�۸�(Ԫ/��)</td>
		<td>����</td>
		<td>�ܼ�(Ԫ)</td>
		<td>�Ƴ�(-1/��)</td>
	</tr>
	<%	if(buylist==null||buylist.size()==0){ %>
	<tr height="100"><td colspan="5" align="center">���Ĺ��ﳵΪ�գ�</td></tr>
	<%
		}
		else{
			for(int i=0;i<buylist.size();i++){
				GoodsSingle single=(GoodsSingle)buylist.get(i);
				String name=single.getName();			//��ȡ��Ʒ����
				float price=single.getPrice();			//��ȡ��Ʒ�۸�
				int num=single.getNum();				//��ȡ��������
				//���㵱ǰ��Ʒ�ܼۣ���������������
				float money=((int)((price*num+0.05f)*10))/10f;
				total+=money; 							//����Ӧ�����
	%>
	<tr align="center" height="50">
		<td><%=name%></td>
		<td><%=price%></td>
		<td><%=num%></td>
		<td><%=money%></td>
		<td><a href="doCar?action=remove&name=<%=single.getName() %>">�Ƴ�</a></td>
	</tr>
	<%
			}
		}
	%>
	<tr height="50" align="center"><td colspan="5">Ӧ����<%=total%></td></tr>
	<tr height="50" align="center">
		<td colspan="2"><a href="show.jsp">��������</a></td>
		<td colspan="3"><a href="doCar?action=clear">��չ��ﳵ</a></td>
	</tr>
</table>
