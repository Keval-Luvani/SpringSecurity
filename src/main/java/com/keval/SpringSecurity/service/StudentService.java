package com.keval.SpringSecurity.service;

import java.util.List;

import com.keval.SpringSecurity.model.Student;

public interface StudentService {
	public List<Student> getStudents();
	public Student getStudent(String name);
	public void deleteStudent(int studentId);
	public Student addStudent(Student student);
	public Student updateStudent(Student student, int studentId);
}
