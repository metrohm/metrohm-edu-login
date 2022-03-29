package com.metrohm.edulogin.controller;

import com.metrohm.edulogin.model.User;
import com.metrohm.edulogin.service.InvalidPasswordException;
import com.metrohm.edulogin.service.UserNotFoundException;
import com.metrohm.edulogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * LoginController
 *
 * @author lorenzboesch, Metrohm AG
 * @since 03.03.21 15:45
 */
@Controller
public class LoginController {

	protected final UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String showLogin(@RequestParam(name = "errorMessage", required = false) String errorMessage,
	                        Model model) {
		model.addAttribute("errorMessage", errorMessage);
		return "login";
	}

	@PostMapping("/login")
	public String login(
			@ModelAttribute("username") String username,
			@ModelAttribute("password") String password,
			HttpServletRequest request,
			Model model) {

		User user = null;
		try {
			user = userService.loadUser(username, password);
		} catch (UserNotFoundException | InvalidPasswordException e) {
			return showLogin("invalid username or password", model);
		}
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "redirect:/profile";
		}
		return showLogin(null, model);
	}
}
