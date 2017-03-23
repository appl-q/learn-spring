package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toolbean.MyTools;
import valuebean.WordSingle;

public class WordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���´���������ȡ�����ֶ����ݲ�����ת��
		String author=MyTools.toChinese(request.getParameter("author"));
		String title=MyTools.toChinese(request.getParameter("title"));
		String content=MyTools.toChinese(request.getParameter("content"));
		
		//��ȡ��ǰʱ�䲢��ʽ��ʱ��Ϊָ����ʽ
		String today=MyTools.changeTime(new Date());
		
		WordSingle single=new WordSingle();									//����ֵJavaBean����������װ��ȡ����Ϣ
		single.setAuthor(MyTools.changeHTML(author));
		single.setTitle(MyTools.changeHTML(title));
		single.setContent(content);
		single.setTime(today);
		
		HttpSession session=request.getSession();							//��ȡsession����
		ServletContext scx=session.getServletContext();						//ͨ��session�����ȡӦ��������
		ArrayList wordlist=(ArrayList)scx.getAttribute("wordlist");			//��ȡ�洢��Ӧ���������еļ��϶���
		if(wordlist==null)
			wordlist=new ArrayList();
		wordlist.add(single);								//����װ����Ϣ��ֵJavaBean�洢�����϶�����
		scx.setAttribute("wordlist",wordlist);				//�����϶��󱣴浽Ӧ����������
		response.sendRedirect("show.jsp");					//�������ض���show.jspҳ��
	}
}
