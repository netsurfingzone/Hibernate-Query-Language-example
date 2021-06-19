package com.netsurfingzone.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.netsurfingzone.entity.Address;
import com.netsurfingzone.entity.Student;

public class HibernateMain {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		Configuration configuration = new Configuration().configure();
		try {

			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Long id = 2l;
			String hql = "from Address address left outer join fetch address.student where address.id=:id";
			Query<Address> query = session.createQuery(hql, Address.class);
			query.setParameter("id", id);
			Address address = query.uniqueResult();
			Student student = address.getStudent();
			if (address != null && student != null) {
				System.out.println("City is " + address.getCity());
				System.out.println("Pincode is " + address.getPinCode());
				System.out.println("Student name is " + student.getName());
				System.out.println("Student name is " + student.getRollNumber());
				System.out.println("Student name is " + student.getUniversity());
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}
	}

}
