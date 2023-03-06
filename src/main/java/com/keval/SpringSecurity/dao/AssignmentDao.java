package com.keval.SpringSecurity.dao;

import java.util.List;

import com.keval.SpringSecurity.model.Assignment;

public interface AssignmentDao {
	public List<Assignment> getAssignments();
	public Assignment getAssignment(int assignmentId);
	public void createAssignment(Assignment assignment);
	public void updateAssignment(Assignment assignment);
	public void deleteAssignment(int assignmentId); 
}
