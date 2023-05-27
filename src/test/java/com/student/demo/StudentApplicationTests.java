package com.student.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.demo.model.Student;
import com.student.demo.repository.StudentRepository;
import com.student.demo.service.StudentService;

@SpringBootTest
class StudentApplicationTests {

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudentTest(){
		Student student = new Student(1, "Jeet", "Kolhapur");
		when(studentRepository.save(student)).thenReturn(student);
		Student stud = studentService.saveStudent(student);
		assertEquals(student, stud);		
	}
	
	@Test
	public void getStudent() {
		Student student = new Student(1, "Jeet", "Kolhapur");
		when(studentRepository.findById(1)).thenReturn(student);
		Student stud = studentService.getStudent(1);
		assertEquals("Jeet", stud.getName());
	}
}
