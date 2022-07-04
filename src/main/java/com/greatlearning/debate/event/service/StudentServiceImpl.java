package com.greatlearning.debate.event.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.debate.event.dao.StudentDao;
import com.greatlearning.debate.event.entity.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student addStudent(Student student) {
		return studentDao.Insert(student);
	}

	@Override
	public Student getStudent(int id) {
		return studentDao.findStudent(id);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDao.Update(student);
	}

	@Override
	public boolean deleteStudent(int id) {
		return studentDao.Delete(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.retrieveDetails();
	}
}