package com.student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findById(int id);
}
