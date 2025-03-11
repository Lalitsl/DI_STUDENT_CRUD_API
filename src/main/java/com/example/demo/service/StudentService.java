package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entities.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
//	CREATE A NEW STUDENT OR UPDATE STUDENT
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
//	GET ALL STUDENT RECORDS
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
//	GET RECORDS BY ID 
	public Optional<Student> getStudentById(Long id){
		return studentRepository.findById(id);
	}
	
//  DELTE STUDENT RECORD
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	
	
	
	
}
