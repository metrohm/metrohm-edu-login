package com.metrohm.edulogin.controller;

import com.metrohm.edulogin.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * ProfileController
 *
 * @author lorenzboesch, Metrohm AG
 * @since 03.03.21 15:45
 */
@Controller
public class ProfileController {

	@GetMapping
	public String home() {
		return "redirect:/profile";
	}

	@GetMapping("/profile")
	public String profile(Model model,
	                      HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		model.addAttribute("user", user);
		return "profile";
	}
}
