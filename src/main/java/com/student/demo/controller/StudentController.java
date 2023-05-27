package com.student.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.model.Student;
import com.student.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student save = studentService.saveStudent(student);
		return new ResponseEntity<Student>(save, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> saveStudent(@PathVariable int id,@RequestBody Student student){
		Student update = studentService.updateStudent(id,student);
		return new ResponseEntity<Student>(update, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getSingle(@PathVariable int id){
		Student student = studentService.getStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> list = studentService.getAll();
		return new ResponseEntity<List<Student>>(list, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		studentService.deleteStudent(id);
		return new ResponseEntity<>(Map.of("Message", "Student successfully deleted...!"), HttpStatus.ACCEPTED);
	}
}
