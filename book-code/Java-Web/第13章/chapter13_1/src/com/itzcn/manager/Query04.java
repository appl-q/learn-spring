package com.itzcn.manager;

import org.hibernate.Session;

import com.itzcn.dao.Student;
import com.itzcn.hibernatesession.HibernateSessionFactory;

public class Query04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = null;//����Session����
		Session session2 = null;//����Session����
		try{
			session = HibernateSessionFactory.getSession();//��ȡSession
			session2 = HibernateSessionFactory.getSession();//��ȡSession
			System.out.println("��һ�β�ѯ��");
			Student student = (Student) session.get(Student.class, new Integer(2));//���ض���
			System.out.println("name:" + student.getName());
			System.out.println("�ڶ��β�ѯ��");
			Student student2 = (Student) session2.get(Student.class, new Integer(2));//���ض���
			System.out.println("name:" + student2.getName());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();//�ر�Session����
		}
	}

}
