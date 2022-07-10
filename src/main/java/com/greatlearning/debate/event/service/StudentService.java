package com.greatlearning.debate.event.service;

import java.util.List;

import com.greatlearning.debate.event.entity.Student;

public interface StudentService {

	public Student addStudent(Student student);

	public Student getStudent(Integer id);
	
	public Student updateStudent(Student student);

	public boolean deleteStudent(Integer id);

	public List<Student> getAllStudents();

}
