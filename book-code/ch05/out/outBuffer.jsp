<%@page contentType="text/html"%>
<%@page pageEncoding="GB2312"%>
<html>
    <head><title>��ʾ out ���󻺳����Ĳ���</title></head>
    <body>
        <%
            out.println("JSP�������<br>");
            out.clearBuffer();//clearBuffer()�������������е����������
            out.println("�廪������<br>");
            out.flush();//�Ȱѻ�����ԭ������д���ͻ����ϣ�����ջ������������ 
            out.println("��������<br>");
            out.println("==========<br>");
            out.println("ʣ�໺������С��" + 
                          out.getRemaining() + " bytes<br>");
            out.println("Ԥ�軺������С��" + 
                          out.getBufferSize() + " bytes<br>");
            out.println("AutoFlush��" + out.isAutoFlush());
            out.close();//�ر���������Ӷ�����ǿ����ֹ��ǰ��ʣ�ಿ������������
            out.print("hello");
            %>

        %>
    </body>
</html>
