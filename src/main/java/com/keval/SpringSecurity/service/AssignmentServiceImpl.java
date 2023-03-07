package com.keval.SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.keval.SpringSecurity.dao.AssignmentDao;
import com.keval.SpringSecurity.model.Assignment;

@Component
public class AssignmentServiceImpl implements AssignmentService {
	@Autowired
	AssignmentDao assignmentDaoImpl;
	
	public List<Assignment> getAssignments() {
		return assignmentDaoImpl.getAssignments();
	}

	public Assignment getAssignment(int assignmentId) {
		return assignmentDaoImpl.getAssignment(assignmentId);
	}

	public void createAssignment(Assignment assignment) {
		assignmentDaoImpl.createAssignment(assignment);
	}

	public void updateAssignment(Assignment assignment) {
		assignmentDaoImpl.updateAssignment(assignment);
	}

	public void deleteAssignment(int assignmentId) {
		assignmentDaoImpl.deleteAssignment(assignmentId);
	}
}
