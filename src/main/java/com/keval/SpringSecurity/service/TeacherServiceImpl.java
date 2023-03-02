package com.keval.SpringSecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.keval.SpringSecurity.model.Student;
import com.keval.SpringSecurity.model.Teacher;

@Component
public class TeacherServiceImpl implements TeacherService {
	List<Teacher> teachers = new ArrayList<>();	
	
	public TeacherServiceImpl() {
		super();
		teachers.add(new Teacher("teachera","Maths"));
		teachers.add(new Teacher("teacherb","Science"));
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public Teacher getTeacher(String teacherName) {
		return teachers.stream().filter((Teacher)->Teacher.getName().equals(teacherName)).findAny().orElse(null);
	}

	public void deleteTeacher(int teacherId) {
		Teacher teacher = teachers.stream().filter((Teacher)->Teacher.getId()== teacherId).findAny().orElse(null);
		teachers.remove(teacher);   
	}

	public Teacher addTeacher(Teacher teacher) {
		if(teachers.add(teacher)) {
			return teacher;
		}else {
			return null;
		}
	}

	public Teacher updateTeacher(Teacher teacher, int teacherId) {
		return new Teacher();
	}

}

