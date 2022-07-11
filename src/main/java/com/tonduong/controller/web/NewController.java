package com.tonduong.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "news")//hai controller Giống tên => cần đặt tên
//@RequestMapping(value = "/trang-chu")
public class NewController {
  
   @RequestMapping(value = {"/news-list"}, method = RequestMethod.GET)
   public ModelAndView showNews() {
      ModelAndView mav = new ModelAndView("web/home");
//      mav.addObject("message", "Hello Ton Duong ModelAndView");
//      mav.getModelMap().addAttribute("message", "Hello Ton Duong ModelAndView");
      return mav;
   }
   
   @RequestMapping(value = {"/news-edit"}, method = RequestMethod.GET)
   public String editNews(ModelMap map) {
	   map.addAttribute("message", "Hello Ton Duong ModelMap");
	   return "web/home";
   }
  
//   @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
//   public ModelAndView springMVCPage() {
//      ModelAndView mav = new ModelAndView("springmvc");
//      return mav;
//   }
}