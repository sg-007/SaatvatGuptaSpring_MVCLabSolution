package com.greatlearning.debate.event.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.greatlearning.debate.event.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory;
	private Session session;
	
	public StudentDaoImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
		}	catch (HibernateException e) {
				session = sessionFactory.openSession();
		}
	}
	
	@Override
	public Student Insert(Student student) {
		//Transaction tx = session.beginTransaction();
		session.save(student);
		//tx.commit();
		return student;
	}

	@Override
	public Student Update(Student student) {
		sessionFactory.getCurrentSession();
		session.update(student);
		return student;
	}

	@Override
	public boolean Delete(int id) {
		Student retrieved = findStudent(id);
		session.getTransaction().begin();
		session.delete(retrieved);
		session.getTransaction().commit();
		if (retrieved != null)
			return true;
		return false;
	}

	@Override
	public Student findStudent(int id) {
		return session.find(Student.class, id);
	}

	@Override
	public List<Student> retrieveDetails() {
		return session.createQuery("Select s from Student s", Student.class).getResultList();
	}
}