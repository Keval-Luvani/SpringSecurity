package com.keval.SpringSecurity.service;

import com.keval.SpringSecurity.model.Teacher;
import java.util.List;

public interface TeacherService {
	public List<Teacher> getTeachers();
	public Teacher getTeacher(String name);
	public void deleteTeacher(int teacherId);
	public Teacher addTeacher(Teacher teacher);
	public Teacher updateTeacher(Teacher teacher, int teacherId);
}
