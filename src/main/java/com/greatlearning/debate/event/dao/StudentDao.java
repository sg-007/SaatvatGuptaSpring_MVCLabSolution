package com.greatlearning.debate.event.dao;

import java.util.List;

import com.greatlearning.debate.event.entity.Student;

public interface StudentDao {

	public Student Insert(Student student);

	public Student Update(Student student);

	public boolean Delete(int id);

	public Student findStudent(int id);

	public List<Student> retrieveDetails();
}
