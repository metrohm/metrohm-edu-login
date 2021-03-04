package com.metrohm.edulogin;

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

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(
			@ModelAttribute("username") String username,
			@ModelAttribute("password") String password,
			HttpServletRequest request) {

		//todo ask userservice for user
		User user = null;
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "redirect:/profile";
		}
		return showLogin();
	}
}
