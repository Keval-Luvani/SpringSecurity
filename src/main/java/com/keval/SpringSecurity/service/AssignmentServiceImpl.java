package com.keval.SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.keval.SpringSecurity.config.MySecurityConfig;
import com.keval.SpringSecurity.dao.AssignmentDao;
import com.keval.SpringSecurity.model.Assignment;
import com.keval.SpringSecurity.model.User;
import com.keval.SpringSecurity.model.UserDetailImpl;

@Component
public class AssignmentServiceImpl implements AssignmentService {
	@Autowired
	AssignmentDao assignmentDaoImpl;
	@Autowired
	private MySecurityConfig mySecurityConfig;
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
	public List<Assignment> getAssignments() {
		return assignmentDaoImpl.getAssignments();
	}

	
	public Assignment getAssignment(int assignmentId) {
		return assignmentDaoImpl.getAssignment(assignmentId);
	}

	public void createAssignment(Assignment assignment) {
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
		    UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();
		    User user = userDetails.getUser();
		    assignment.setCreatedBy(user.getId());
		}
		assignmentDaoImpl.createAssignment(assignment);
	}

	public void updateAssignment(Assignment assignment) {
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
		    UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();
		    User user = userDetails.getUser();
		    assignment.setCreatedBy(user.getId());
		}
		
		assignmentDaoImpl.updateAssignment(assignment);
	}

	public void deleteAssignment(int assignmentId) {
		assignmentDaoImpl.deleteAssignment(assignmentId);
	}
}
