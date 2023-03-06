package com.keval.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keval.SpringSecurity.model.Assignment;
import com.keval.SpringSecurity.service.AssignmentService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
	@Autowired
	AssignmentService assignmentServiceImpl; 
	
	@RequestMapping("/view")
	public String viewAssignment(Model model) {
		model.addAttribute("assignmentList",assignmentServiceImpl.getAssignments());
		return "../ViewAssignment.jsp";
	}
	
	@RequestMapping("/create")
	public String createPage(Model model) {
		model.addAttribute("assignment",new Assignment());
		return "../AssignmentEntry.jsp";
	}
	
	@RequestMapping("/update{assignmentId}")
	public String updatePage(Model model,@PathVariable int assignmentId) {
		model.addAttribute("assignment",assignmentServiceImpl.getAssignment(assignmentId));
		return "../AssignmentEntry.jsp";
	}
	
	@RequestMapping("/delete{assignmentId}")
	public String Assignment(@PathVariable int assignmentId) {
		assignmentServiceImpl.deleteAssignment(assignmentId);
		return "redirect:/assignment/view";
	}
	
	@RequestMapping(value="/submit", method= RequestMethod.POST)
	public String createAssignment(@ModelAttribute() Assignment assignment) {
		assignmentServiceImpl.updateAssignment(assignment);
		return "redirect:/assignment/view";
	}
}
