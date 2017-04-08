package com.itzcn.manager;

import org.hibernate.Session;

import com.itzcn.dao.Student;
import com.itzcn.hibernatesession.HibernateSessionFactory;

public class Delete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = null;//����Session����
		try{
			session = HibernateSessionFactory.getSession();//��ȡSession
			session.beginTransaction();//��������
			Student student = (Student) session.load(Student.class, new Integer(1));//���ض���
			session.delete(student);//ɾ��Student
			session.getTransaction().commit();//�ύ����
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();//�����ع�����
		}finally{
			HibernateSessionFactory.closeSession();//�ر�Session����
		}
	}

}
