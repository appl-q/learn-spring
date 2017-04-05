<%@ page language="java" pageEncoding="GB2312"%>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.data.general.DefaultPieDataset" %>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection" %>
<%@ page import="org.jfree.chart.ChartRenderingInfo" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>

<%
DefaultPieDataset dataset1=new DefaultPieDataset();
dataset1.setValue("ASPר��",200);
dataset1.setValue("PHPר��",150);
dataset1.setValue("Javaר��",450);
dataset1.setValue("DoNetר��",400);

//����JFreeChart�����ͼ�����
JFreeChart chart=ChartFactory.createPieChart(
									"��̳�������ָ������ͼ",	//ͼ�����
									dataset1,				//���ݼ�
									true,					//�Ƿ����ͼ��
									false,					//�Ƿ����ͼ��˵��
									false					//�Ƿ��������
									);
//����ͼ����ļ���
// �̶��÷�
ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
String fileName=ServletUtilities.saveChartAsPNG(chart,400,270,info,session);
String url=request.getContextPath()+"/servlet/DisplayChart?filename="+fileName;
%>

<html>
  <head>
    <title>���Ʊ���ͼ</title>
  </head>
  
  <body topmargin="0">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<img src="<%=url%>">
	</td>
  </tr>
</table>
  </body>
  
</html>
