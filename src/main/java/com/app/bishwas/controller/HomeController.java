package com.app.bishwas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.bishwas.domain.User;
import com.app.bishwas.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private IUserService userService;

	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(HomeController.class);
	 */

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "authFailed", required = false) String authFailed,
			@RequestParam(value = "unauthorized", required = false) boolean unauthorized,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (authFailed != null) {
			model.addObject("authFailed", "Invalid username and password");
		}
		if (unauthorized) {
			model.addObject("authFailed", "Sorry, you are not allowed to view this page. You are logged out.");
		}
		if (logout != null) {
			model.addObject("msg", "You've been loged out successfully.");
		}
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/auth/admin", method = RequestMethod.GET)
	public String openHome(Model model) {
		model.addAttribute("users", userService.findAllUser());
		return "home";
	}

	@RequestMapping(value = "/auth/admin/add", method = RequestMethod.GET)
	public String openAddUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	@RequestMapping(value = "/auth/admin/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user) {
		userService.addUser(user);
		return "redirect:/auth/admin";
	}

	@RequestMapping(value = "/auth/admin/edit", params = { "id" }, method = RequestMethod.GET)
	public String openEditUser(@RequestParam("id") int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "addUser";
	}

	@RequestMapping(value = "/auth/admin/edit", method = RequestMethod.POST)
	public String openEditUser(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, @ModelAttribute User user) {
		if (cancel != null) {
			return "redirect:/auth/admin";
		} else {
			userService.updateUser(user);
		}
		return "redirect:/auth/admin";
	}

	@RequestMapping(value = "/auth/admin/remove", params = { "id" }, method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id) {
		userService.removeUser(id);
		return "redirect:/auth/admin";
	}

}
