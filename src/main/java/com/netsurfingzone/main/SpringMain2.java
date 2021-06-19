package com.netsurfingzone.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.netsurfingzone.entity.Student;

public class SpringMain2 {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		Configuration configuration = new Configuration().configure();
		try {

			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			//Save some records using session.save() method
/*			Student s1 = new Student();
			s1.setName("Rax");
			s1.setRollNumber("0126CS789");
			s1.setUniversity("RGTU");
			
			Student s2 = new Student();
			s2.setName("Peter");
			s2.setRollNumber("0126CS790");
			s2.setUniversity("RGTU");
			
			Student s3 = new Student();
			s3.setName("Jon");
			s3.setRollNumber("0126CS790");
			s3.setUniversity("RGTU");
			
			session.save(s1);
			session.save(s2);
			session.save(s3);*/
			
			//Query query=session.createQuery("from Student s ORDER BY s.name"); 
			//query.setParameter("university", "RTGU");
			//query.setParameter("name", "John");
			//String hql = "SELECT E.firstName FROM Employee E";
			//String hql = "FROM Student s ORDER BY s.name asc";
			//Query query=session.createQuery("from Student s ORDER BY s.name"); 
			//Query query=session.createQuery("from Student s ORDER BY s.name asc");
			//Query query=session.createQuery("from Student s ORDER BY s.name asc, s.rollNumber desc");
			//"select bk.writer, max(bk.price) from Book as bk group by bk.writer";
/*			Query query=session.createQuery("from Student s ORDER BY s.name asc, s.rollNumber desc");
			List<Student> students = query.list();
			students.forEach(student -> {
				System.out.println("Name is - "+student.getName());
				System.out.println("RollNumber is - "+student.getRollNumber());
				System.out.println("University is - "+student.getUniversity());
			});*/
			
			// Insert, update and delete example using HQL
/*			String insertQuery = "insert into Student(id, name, rollNumber, university)"
					+ "select id, name, rollNumber, university from StudentBackup";
			Query query = session.createQuery(insertQuery);
			if (query.executeUpdate() > 0) {
				System.out.println("Record inserted to student table successfully");
			}
			
			Long id = 2l;
			String rollNumber = "3333";
			String updateQueryAsQuery = "update Student set rollNumber=:rollNumber where id=:id";
			Query updateQuery = session.createQuery(updateQueryAsQuery);
			updateQuery.setParameter("rollNumber", rollNumber);
			updateQuery.setParameter("id", id);

			id = 2l;
			String deleteQueryAsString = "delete Student where id=:id";
			Query deleteQuery = session.createQuery(deleteQueryAsString);
			deleteQuery.setParameter("id", id);
			if (deleteQuery.executeUpdate() > 0) {
				System.out.println("Record deleted successfully");
			}*/
			
			//Pagination example
			
/*			Query query=session.createQuery(" from Student");
			query.setFirstResult(1);
			query.setMaxResults(5);
			List<Student> list = query.list();
			list.forEach(student -> {
				System.out.println("Name is - "+student.getName());
				System.out.println("RollNumber is - "+student.getRollNumber());
				System.out.println("University is - "+student.getUniversity());
			});*/
			
			
			//Group by example using Hibernate query language
			
/*			Query query=session.createQuery(" select s.name, count(*) from Student s group by s.name  order by s.name asc");
			List<Object> list = query.list();
			for(int i = 0; i< list.size(); i++){
				Object[] objectArray=(Object[])list.get(i);
				System.out.println("total count of "+objectArray[0]+ " is "+objectArray[1]);
			}*/
			
/*			list.forEach(object->{
				Object[] objectArray=(Object[])list.get(0);
				System.out.println("total count of "+objectArray[0]+ "is"+objectArray[1]);
			});*/
			
			
			
/*			students.forEach(student -> {
				System.out.println("Name is - "+student.getName());
				System.out.println("RollNumber is - "+student.getRollNumber());
				System.out.println("University is - "+student.getUniversity());
			});*/
			
			Query query =session.createQuery("select avg(age) from Student");  
			List<Student> list = query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}
	}

}
