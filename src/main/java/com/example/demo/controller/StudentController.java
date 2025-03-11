package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

//	SAVE STUDENT OR UPDATE STUDENT 
	@PostMapping("/api/saveStudent")
	public ResponseEntity<Student> createOrUpdateStudent(@RequestBody Student student){
		Student savedStudent =studentService.saveStudent(student);
		return ResponseEntity.ok(savedStudent) ;
	}
	
	
//	GET ALL STUDENTS RECORDS USING GET METHOD
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
//    @GetMapping("/api/students")
//    public ResponseEntity<List<Student>> getAllStudents() {
//        List<Student> students = studentService.getAllStudents();
//        return ResponseEntity.ok(students);
//    }
	
//	GET ALL STUDENTS RECORDS USING POST METHOD
	 @PostMapping("/api/students")
	    public ResponseEntity<List<Student>> getAllStudents() {
	        List<Student> students = studentService.getAllStudents();
	        return ResponseEntity.ok(students);
	    }
	 
	 
	 
	 

// GET STUDENT BY ID
//    @GetMapping("/api/students/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
//        Optional<Student> student = studentService.getStudentById(id);
//        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
	
	 
// GET STUDENT RECORD BY ID USING REQUEST BODY
	@PostMapping("/api/students/get")
	public ResponseEntity<Optional<Student>> getStudentById(@RequestBody Map<String, Long> request) {
	    Long id = request.get("id");
	    Optional<Student> student = studentService.getStudentById(id);
	    if (student != null) {
	        return ResponseEntity.ok(student);
	    } else {
	        return ResponseEntity.notFound().build(); 
	    }
	}

    
    
// DELETE RECORD BY ID
//    @DeleteMapping("/api/students/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.noContent().build();
//    }
    
//    DELETE RECORD BY ID USING REQUEST BODY
    @PostMapping("/api/students/delete")
    public ResponseEntity<Void> deleteStudent(@RequestBody Map<String, Long> request) {
        Long id = request.get("id"); // Extracting ID from request body
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


    
	
	
}
