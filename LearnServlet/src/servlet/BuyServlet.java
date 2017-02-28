package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import toolbean.MyTools;
import toolbean.ShopCar;
import valuebean.GoodsSingle;

public class BuyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");	//��ȡaction����ֵ
		if(action==null)
			action="";
		if(action.equals("buy"))					//�����ˡ���������
			buy(request,response);						//����buy()����ʵ����Ʒ�Ĺ���
		if(action.equals("remove"))					//�����ˡ��Ƴ�������
			remove(request,response);					//����remove()����ʵ����Ʒ���Ƴ�
		if(action.equals("clear"))					//�����ˡ���չ��ﳵ������
			clear(request,response);					//����clear()����ʵ�ֹ��ﳵ�����
	}
	//ʵ�ֹ�����Ʒ�ķ���
	protected void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();		
		String strId=request.getParameter("id");		//��ȡ��������������ʱ���ݵ�id�������ò����洢������Ʒ��goodslist�����д洢��λ��	
		int id=MyTools.strToint(strId);
		
		ArrayList goodslist=(ArrayList)session.getAttribute("goodslist");
		GoodsSingle single=(GoodsSingle)goodslist.get(id);
		
		ArrayList buylist=(ArrayList)session.getAttribute("buylist");		//��session��Χ�ڻ�ȡ�洢���û��ѹ�����Ʒ�ļ��϶���
		if(buylist==null)
			buylist=new ArrayList();
		
		ShopCar myCar=new ShopCar();
		myCar.setBuylist(buylist); 						//��buylist����ֵ��ShopCar��ʵ���е�����
		myCar.addItem(single);							//����ShopCar����addItem()����ʵ����Ʒ��Ӳ���
		
		session.setAttribute("buylist",buylist);		
		response.sendRedirect("show.jsp");				//�������ض���show.jspҳ��
	}
	//ʵ���Ƴ���Ʒ�ķ���
	protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList buylist=(ArrayList)session.getAttribute("buylist");
		
		String name=request.getParameter("name");
		ShopCar myCar=new ShopCar();
		myCar.setBuylist(buylist);						//��buylist����ֵ��ShopCar��ʵ���е�����
		myCar.removeItem(MyTools.toChinese(name));		//����ShopCar����removeItem ()����ʵ����Ʒ�Ƴ�����
		
		response.sendRedirect("shopcar.jsp");
	}
	//ʵ����չ��ﳵ�ķ���
	protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList buylist=(ArrayList)session.getAttribute("buylist");			//��session��Χ�ڻ�ȡ�洢���û��ѹ�����Ʒ�ļ��϶���
		buylist.clear();														//���buylist���϶���ʵ�ֹ��ﳵ��յĲ���
		
		response.sendRedirect("shopcar.jsp");
	}
}