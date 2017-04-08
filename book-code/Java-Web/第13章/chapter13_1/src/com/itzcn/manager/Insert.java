package com.itzcn.manager;

import org.hibernate.Session;

import com.itzcn.dao.Student;
import com.itzcn.hibernatesession.HibernateSessionFactory;

public class Insert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = null;//����Session����
		try{
			session = HibernateSessionFactory.getSession();//��ȡSession
			session.beginTransaction();//��������
			Student student = new Student();//ʵ����Student����
			student.setId(2);
			student.setName("wanghua");
			student.setPass("123456");
			session.save(student);//����Student����
			session.getTransaction().commit();//�ύ����
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();//�����ع�����
		}finally{
			HibernateSessionFactory.closeSession();//�ر�Session����
		}
	}

}
