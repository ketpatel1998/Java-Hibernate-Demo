package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ValueObject.Student;

public class DAO {
	
	public void insertIntoStudent(Student s)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(s);
		transaction.commit();
		session.close();
	}

	public List displayStudentData()
	{
		List list = new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("from Student");
		list = q.list();
		transaction.commit();
		session.close();
		return list;
	}
	
	public List displaySingleRowInStudentTable(Student s)
	{
		List list  =  new ArrayList();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("from Student where sid = '"+s.getSid()+"'"); 
		list = q.list();
		transaction.commit();
		session.close();
		return list;
		
	}
	
	public void updateSingleRowInStudentTable(Student s)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(s);
		//session.update(s);
		transaction.commit();
		session.close();
	}
	
	public void deleteSingleRowInStudentTable(Student s)
	{
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(s);
		transaction.commit();
		session.close();
		
	}
	
}
