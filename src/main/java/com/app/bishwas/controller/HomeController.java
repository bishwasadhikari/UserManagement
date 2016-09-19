package com.app.bishwas.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.bishwas.domain.User;
import com.app.bishwas.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private IUserService userService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
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
		return "redirect:/";
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
			return "redirect:/";
		} else {
			userService.updateUser(user);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/auth/admin/remove", params = { "id" }, method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id) {
		userService.removeUser(id);
		return "redirect:/";
	}

}
