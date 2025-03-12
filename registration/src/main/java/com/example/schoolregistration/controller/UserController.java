package com.example.schoolregistration.controller;

import com.example.schoolregistration.model.User;
import com.example.schoolregistration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

	 @Autowired
	    private UserService userService;

	    // Show registration form
	    @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("user", new User());
	        return "registration";
	    }

	    // Handle form submission
	    @PostMapping("/register")
	    public String registerUser(@Valid User user, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "registration"; // Return to the form if there are errors
	        }
	        userService.saveUser(user); // Save the user
	        return "redirect:/success"; // Redirect to the success page
	    }

	    // Success page
	    @GetMapping("/success")
	    public String showSuccessPage() {
	        return "success";
	    }
	

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }
}