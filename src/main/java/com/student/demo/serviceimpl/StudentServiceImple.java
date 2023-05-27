package com.student.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.model.Student;
import com.student.demo.repository.StudentRepository;
import com.student.demo.service.StudentService;

@Service
public class StudentServiceImple implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Student saveStudent(Student student) {		
		return studentRepository.save(student);
	}
	@Override
	public Student getStudent(int id) {
		Student student = studentRepository.findById(id);
		return student;
	}
	@Override
	public List<Student> getAll() {
		List<Student> list = studentRepository.findAll().stream().collect(Collectors.toList());
		return list;
	}
	@Override
	public void deleteStudent(int id) {
		Student student = studentRepository.findById(id);
		studentRepository.delete(student);
		
	}
	@Override
	public Student updateStudent(int id, Student student) {
		Student stud = studentRepository.findById(id);
		
		stud.setName(student.getName());
		stud.setCity(student.getCity());
		
		return studentRepository.save(stud);
	}

}
