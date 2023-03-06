package com.keval.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keval.SpringSecurity.model.User;
import com.keval.SpringSecurity.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userServiceImpl; 
	
	@RequestMapping("/view")
	public String viewUsers(Model model) {
		model.addAttribute("userList",userServiceImpl.getUsers());
		return "../ViewUser.jsp";
	}
	
	@RequestMapping("/create")
	public String createPage(Model model) {
		model.addAttribute("user",new User());
		return "../UserEntry.jsp";
	}
	
	@RequestMapping("/update{userId}")
	public String updatePage(Model model,@PathVariable int userId) {
		model.addAttribute("user",userServiceImpl.getUser(userId));
		return "../UserEntry.jsp";
	}
	
	@RequestMapping("/delete{userId}")
	public String deleteUser(@PathVariable int userId) {
		userServiceImpl.deleteUser(userId);
		return "redirect:/user/view";
	}
	
	@RequestMapping(value="/submit", method= RequestMethod.POST)
	public String createUser(@ModelAttribute() User user) {
		userServiceImpl.createUser(user);
		return "redirect:/user/view";
	}
}
