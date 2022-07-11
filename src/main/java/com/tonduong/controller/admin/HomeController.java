package com.tonduong.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "admin-home") // hai controller Giống tên => cần đặt tên
//@RequestMapping(value = "/admin")
public class HomeController {

	@RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

//   @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
//   public ModelAndView springMVCPage() {
//      ModelAndView mav = new ModelAndView("springmvc");
//      return mav;
//   }
	
}