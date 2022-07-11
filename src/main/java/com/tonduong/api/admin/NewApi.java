package com.tonduong.api.admin;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tonduong.dto.NewDTO;
import com.tonduong.repository.NewReponsitory;

@Controller(value = "api-new")
public class NewApi {

	@Autowired
	private NewReponsitory newReponsitory;

	@GetMapping(value = "/api/new")
	@ResponseBody
	public String get(@RequestParam(required = false) Long[] ids) {
		return "get";
	}

	@PostMapping(value = "/api/new")
	@ResponseBody
	public NewDTO create(@RequestBody NewDTO news, HttpServletRequest request) {

//		newReponsitory.save();
		return news;
	}

	@PutMapping(value = "/api/new")
	@ResponseBody
	public String update(@RequestBody NewDTO news) {

		return "update";
	}

	@DeleteMapping(value = "/api/new")
	@ResponseBody

	public String delete(@RequestBody Long[] ids) {

		return "delete";
	}
}
