package com.student.demo.service;

import java.util.List;

import com.student.demo.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	
	public Student getStudent(int id);
	
	public List<Student> getAll();
	
	public void deleteStudent(int id);
	
	public Student updateStudent(int id, Student student);
}
