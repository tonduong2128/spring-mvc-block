package com.tonduong.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "home") // hai controller Giống tên => cần đặt tên
//@RequestMapping(value = "/trang-chu")
public class HomeController {

	@RequestMapping(value = {"/", "/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
//      mav.addObject("message", "Hello Ton Duong ModelAndView");
//      mav.getModelMap().addAttribute("message", "Hello Ton Duong ModelAndView");
		return mav;
	}

	// hoặc
	// Không trả về header khi sử dụng decorator
//   @RequestMapping(value = "/trang-chu-fake", method = RequestMethod.GET)
//   public String homePage(ModelMap map) {
//	   map.addAttribute("message", "Hello Ton Duong ModelMap");
//	   return "web/home";
//   }
//  
//   @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
//   public ModelAndView springMVCPage() {
//      ModelAndView mav = new ModelAndView("springmvc");
//      return mav;
//   }
	
}