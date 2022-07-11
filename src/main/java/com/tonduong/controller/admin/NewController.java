package com.tonduong.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tonduong.entity.NewEntity;
import com.tonduong.model.NewModel;
import com.tonduong.service.INewService;

@Controller(value = "admin-new") // hai controller Giống tên => cần đặt tên
//@RequestMapping(value = "/admin")
public class NewController {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private INewService newService;

	@RequestMapping(value = { "/admin/new-list" }, method = RequestMethod.GET)
	public ModelAndView showList(@ModelAttribute NewModel model) {
		ModelAndView mav = new ModelAndView("admin/new/list");

		model.setListResult(newService.findAll());
		mav.addObject("model", model);
		
		return mav;
	}

	@RequestMapping(value = "/admin/new-edit", method = RequestMethod.GET)
	public ModelAndView showEdit() {
		ModelAndView mav = new ModelAndView("admin/new/list");
		return mav;
	}
}