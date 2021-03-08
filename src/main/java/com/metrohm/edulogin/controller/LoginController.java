package com.metrohm.edulogin.controller;

import com.metrohm.edulogin.model.User;
import com.metrohm.edulogin.service.UserNotFoundException;
import com.metrohm.edulogin.service.UserService;
import com.metrohm.edulogin.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * LoginController
 *
 * @author lorenzboesch, Metrohm AG
 * @since 03.03.21 15:45
 */
@Controller
public class LoginController {

	UserService userService = new UserServiceImpl();

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(
			@ModelAttribute("username") String username,
			@ModelAttribute("password") String password,
			HttpServletRequest request) {

		User user = null;
		try {
			user = userService.loadUser(username, password);
		} catch (UserNotFoundException e) {
			//todo show error message
			e.printStackTrace();
		}
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "redirect:/profile";
		}
		return showLogin();
	}
}
