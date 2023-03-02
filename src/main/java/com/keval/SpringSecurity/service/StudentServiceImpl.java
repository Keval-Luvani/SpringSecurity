package com.keval.SpringSecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.keval.SpringSecurity.model.Student;

@Component
public class StudentServiceImpl implements StudentService {
	List<Student> students = new ArrayList<>();	
	
	public StudentServiceImpl() {
		super();
		students.add(new Student("keval",95));
		students.add(new Student("xyz",48));
	}

	public List<Student> getStudents() {
		return students;
	}

	public Student getStudent(String studentName) {
		return students.stream().filter((Student)->Student.getName().equals(studentName)).findAny().orElse(null);
	}

	public void deleteStudent(int studentId) {
		Student student = students.stream().filter((Student)->Student.getId()== studentId).findAny().orElse(null);
		students.remove(student);   
	}

	public Student addStudent(Student student) {
		if(students.add(student)) {
			return student;
		}else {
			return null;
		}
	}

	public Student updateStudent(Student student, int studentId) {
		return new Student();
	}

}
