<%@ page language="java"  pageEncoding="gb2312"%>
<%@ page import="java.io.*,com.lowagie.text.*,com.lowagie.text.pdf.*"%>
<%
	response.reset();
	response.setContentType("application/pdf");				//�����ĵ���ʽ
	Document document = new Document();						//����Documentʵ��
	//���������������
	BaseFont bfChinese = BaseFont.createFont("STSong-Light",
			"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	Paragraph par = new Paragraph("�������ĥ�³�",new Font(bfChinese, 12, Font.NORMAL));
	par.add(new Paragraph(" ÷�����Կຮ��",new Font(bfChinese, 12, Font.ITALIC)));
	ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	PdfWriter.getInstance(document, buffer);
	document.open();										//���ĵ�
	document.add(par);		//�������
	document.close();										//�ر��ĵ�
	//����׳�IllegalStateException�쳣������
	out.clear();
	out = pageContext.pushBody();
		DataOutput output = new DataOutputStream(response.getOutputStream());

	byte[] bytes = buffer.toByteArray();
	response.setContentLength(bytes.length);

	for (int i = 0; i < bytes.length; i++) {
		output.writeByte(bytes[i]);
	}
%>
