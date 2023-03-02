	package com.keval.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.keval.SpringSecurity.model.Student;
import com.keval.SpringSecurity.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentServiceImpl;
	
	@GetMapping("/all")
	public List<Student> allStudent() {
		return  studentServiceImpl.getStudents();
	}
	
	@GetMapping("/{name}")
	public Student getStudentByName(@PathVariable("name") String name) {
		return studentServiceImpl.getStudent(name);
	}
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentServiceImpl.addStudent(student);
	}
	
	@PostMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
		return studentServiceImpl.updateStudent(student, studentId);
	}
	
	@GetMapping("/delete/{id}")
	public String  deleteStudent(@PathVariable("id") int studentId) {
		studentServiceImpl.deleteStudent(studentId);
		return "done delete";
	}
	
}
