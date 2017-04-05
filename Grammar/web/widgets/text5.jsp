<%@ page language="java" pageEncoding="gb2312"%>
<%@ page import="java.io.*,com.lowagie.text.*,com.lowagie.text.pdf.*"%>
<%
	response.reset();
	response.setContentType("application/pdf");
	Document document = new Document();
	//��ȡͼƬ��·��
	String filePath=pageContext.getServletContext().getRealPath("images/harvest.jpg");
	Image jpg = Image.getInstance(filePath);
	jpg.setAlignment(Image.MIDDLE);				//����ͼƬ����
	
	Table table=new Table(1);
	table.setAlignment(Table.ALIGN_MIDDLE);		//���ñ�����
	table.setBorderWidth(0); //���߿�����Ϊ0
	table.setPadding(3);						//���߾���Ϊ3
	table.setSpacing(3);
	table.addCell(new Cell(jpg));							//��ͼƬ�����ڱ����
	Cell cellword=new Cell("harvest");
	cellword.setHorizontalAlignment(Cell.ALIGN_CENTER);		//��������ˮƽ����
	table.addCell(cellword);								//��ӱ��
	ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	PdfWriter.getInstance(document, buffer);
	document.open();
	//ͨ�����������ͼƬ������
	document.add(table);
	document.close();
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
