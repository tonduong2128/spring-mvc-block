package com.tonduong.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "auth")
public class AuthController {

	@RequestMapping(value = { "dang-nhap" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", defaultValue = "false") Boolean error,
			HttpServletResponse response, Authentication authentication) throws IOException {
		if (authentication != null && authentication.isAuthenticated()) {
			authentication.setAuthenticated(false);

			response.sendRedirect("/");
			return null;
		}
		ModelAndView modelAndView = new ModelAndView("login");
		if (error) {
			modelAndView.addObject("message", "Username or password is valid");
		}
		return modelAndView;
	}

	@RequestMapping(value = { "dang-xuat" }, method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		// logout //dang config logout ben kia, 2 cai luon :))
		new SecurityContextLogoutHandler().logout(request, response, authentication);
		response.sendRedirect("/dang-nhap");
	}
}
