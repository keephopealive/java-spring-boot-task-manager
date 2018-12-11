package com.codingdojo.taskmanager.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.taskmanager.models.User;
import com.codingdojo.taskmanager.services.UserService;

@Controller
public class TasksController {
	private final UserService userService;
	
	public TasksController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/tasks")
	public String tasks(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId != null) {
			User user = this.userService.findUserById(userId);
			model.addAttribute("user", user);			
			return "tasks/index.jsp";
		} else {
			return "redirect:/login";
		}
	}
}
