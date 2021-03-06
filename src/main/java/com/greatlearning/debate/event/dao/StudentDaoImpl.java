package com.greatlearning.debate.event.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.greatlearning.debate.event.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

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
		session.save(student);
		return student;
	}

	@Override
	public Student Update(Student student) {
		session.save(student);
		return student;
	}

	@Override
	public boolean Delete(Integer id) {
		Student retrieved = findStudent(id);
		session.getTransaction().begin();
		session.delete(retrieved);
		session.getTransaction().commit();
		if (retrieved != null)
			return true;
		return false;
	}

	@Override
	public Student findStudent(Integer id) {
		return session.find(Student.class, id);
	}

	@Override
	public List<Student> retrieveDetails() {
		return session.createQuery("Select s from Student s", Student.class).getResultList();
	}
}