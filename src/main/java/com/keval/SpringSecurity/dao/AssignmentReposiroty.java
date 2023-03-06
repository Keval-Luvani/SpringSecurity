package com.keval.SpringSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.keval.SpringSecurity.model.Assignment;

@Component
public interface AssignmentReposiroty extends JpaRepository<Assignment, Integer> {

}
