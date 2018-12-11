package com.codingdojo.taskmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.taskmanager.models.User;
import com.codingdojo.taskmanager.services.UserService;
import com.codingdojo.taskmanager.validators.UserValidator;

@Controller
public class UsersController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public UsersController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/login";
	}
	
	@PostMapping("/users")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "auth/registration.jsp";
		}
		User u = userService.registerUser(user);
        session.setAttribute("user_id", u.getId());
        return "redirect:/tasks";
	}

	@GetMapping("/login")
	public String showLogin(@Valid @ModelAttribute("user") User user, BindingResult result) {
		return "auth/login.jsp";
	}
	
	@PostMapping("/sessions")
	public String sessions(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		if(this.userService.authenticateUser(user.getEmail(), user.getPassword())) {
			session.setAttribute("user_id", this.userService.findByEmail(user.getEmail()).getId());
			return "redirect:/tasks";
		} else {	
			model.addAttribute("login", "Invalid Credentials");
			return "auth/login.jsp";
		}
	}
	
	@GetMapping("/registration")
	public String showRegistration(@ModelAttribute("user") User user) {
		return "auth/registration.jsp";
	}

}
