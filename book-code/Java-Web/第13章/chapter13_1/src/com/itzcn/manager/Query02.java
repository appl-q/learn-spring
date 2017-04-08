package com.itzcn.manager;

import org.hibernate.Session;

import com.itzcn.dao.Student;
import com.itzcn.hibernatesession.HibernateSessionFactory;

public class Query02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = null;//����Session����
		try{
			session = HibernateSessionFactory.getSession();//��ȡSession
			Student student = (Student) session.load(Student.class, new Integer(2));//���ض���
			System.out.println("id:" + student.getId());
			System.out.println("name:" + student.getName());
			System.out.println("pass:" + student.getPass());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();//�ر�Session����
		}
	}

}
