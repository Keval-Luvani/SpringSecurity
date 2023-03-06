package com.keval.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keval.SpringSecurity.config.MySecurityConfig;
import com.keval.SpringSecurity.model.Assignment;
import com.keval.SpringSecurity.model.User;
import com.keval.SpringSecurity.model.UserDetailImpl;
import com.keval.SpringSecurity.service.AssignmentService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
	@Autowired
	AssignmentService assignmentServiceImpl; 
	@Autowired
	private MySecurityConfig mySecurityConfig;
	
	@RequestMapping("/view")
	public String viewAssignment(Model model) {
		model.addAttribute("assignmentList",assignmentServiceImpl.getAssignments());
		return "../ViewAssignment.jsp";
	}
	
	@PreAuthorize("hasRole('TEACHER')")
	@RequestMapping("/create")
	public String createPage(Model model) {
		model.addAttribute("assignment",new Assignment());
		return "../AssignmentEntry.jsp";
	}
	
	@PreAuthorize("hasRole('TEACHER')")
	@RequestMapping("/update{assignmentId}")
	public String updatePage(Model model,@PathVariable int assignmentId) {
		model.addAttribute("assignment",assignmentServiceImpl.getAssignment(assignmentId));
		return "../AssignmentEntry.jsp";
	}
	
	@PreAuthorize("hasRole('TEACHER')")
	@RequestMapping("/delete{assignmentId}")
	public String Assignment(@PathVariable int assignmentId) {
		assignmentServiceImpl.deleteAssignment(assignmentId);
		return "redirect:/assignment/view";
	}
	
	@PreAuthorize("hasRole('TEACHER')")
	@RequestMapping(value="/submit", method= RequestMethod.POST)
	public String createAssignment(@ModelAttribute() Assignment assignment) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
		    UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();
		    User user = userDetails.getUser();
		    if(!(user.getId()==assignment.getCreatedBy())) {
		    	return "../error.jsp";
		    }
		}
		assignmentServiceImpl.updateAssignment(assignment);
		return "redirect:/assignment/view";
	}
}
