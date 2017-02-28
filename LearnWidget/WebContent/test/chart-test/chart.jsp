<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset" %>
<%@ page import="org.jfree.chart.plot.PlotOrientation" %>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection" %>
<%@ page import="org.jfree.chart.ChartRenderingInfo" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>

<%
DefaultCategoryDataset dataset1=new DefaultCategoryDataset();
dataset1.addValue(200,"����","ƻ��");
dataset1.addValue(150,"����","�㽶");
dataset1.addValue(450,"����","����");

dataset1.addValue(400,"����","ƻ��");
dataset1.addValue(200,"����","�㽶");
dataset1.addValue(150,"����","����");

dataset1.addValue(150,"����","ƻ��");
dataset1.addValue(350,"����","�㽶");
dataset1.addValue(200,"����","����");

//����JFreeChart�����ͼ�����
JFreeChart chart=ChartFactory.createBarChart3D(
									"ˮ������ͼ",		//ͼ�����
									"ˮ��",		//x�����ʾ����
									"����",			//y�����ʾ����
									dataset1,	//���ݼ�
									PlotOrientation.VERTICAL,//ͼ����(��ֱ)
									true,		//�Ƿ����ͼ��
									false,		//�Ƿ������ʾ
									false		//�Ƿ����URL
									);
//����ͼ����ļ���
// �̶��÷�
ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
String fileName=ServletUtilities.saveChartAsPNG(chart,400,270,info,session);
String url=request.getContextPath()+"/servlet/DisplayChart?filename="+fileName;
%>
<html>

  <head>
    <title>��������ͼ</title>
  </head>
  
  <body topmargin="0">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>&nbsp;<img src="<%=url %>"></td>
  </tr>
</table>
  </body>
  
</html>
