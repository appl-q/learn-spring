<%@ page language="java"  pageEncoding="gb2312"%>
<%@ page import="java.io.*,com.lowagie.text.*,com.lowagie.text.pdf.*"%>
<%
	response.reset();
	response.setContentType("application/pdf");				//�����ĵ���ʽ
	Rectangle rectPageSize = new Rectangle(PageSize.B5);	//����A4ҳ���С	
	Document document = new Document(rectPageSize);			//����Documentʵ��
	PdfWriter.getInstance(document,new FileOutputStream("welcomePage.pdf"));
	document.addTitle("��ӭҳ");
	document.addAuthor("wgh");
	document.open();										//���ĵ�
	document.add(new Paragraph("Welcome to BeiJing"));		//�������
	document.close();										//�ر��ĵ�
	//����׳�IllegalStateException�쳣������
	out.clear();
	out = pageContext.pushBody();
%>