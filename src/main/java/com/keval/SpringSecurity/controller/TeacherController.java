package com.keval.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.keval.SpringSecurity.model.Teacher;
import com.keval.SpringSecurity.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherServiceImpl;
	
	@GetMapping("/all")
	public List<Teacher> allTeacher() {
		return  teacherServiceImpl.getTeachers();
	}
	
	@GetMapping("/{name}")
	public Teacher getTeacherByName(@PathVariable("name") String name) {
		return teacherServiceImpl.getTeacher(name);
	}
	
	@PostMapping("/create")
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		return teacherServiceImpl.addTeacher(teacher);
	}
	
	@PostMapping("/update/{id}")
	public Teacher updateTeacher(@RequestBody Teacher teacher,@PathVariable("id") int teacherId) {
		return teacherServiceImpl.updateTeacher(teacher, teacherId);
	}
	
	@GetMapping("/delete/{id}")
	public String  deleteTeacher(@PathVariable("id") int teacherId) {
		teacherServiceImpl.deleteTeacher(teacherId);
		return "done delete";
	}
	
}
