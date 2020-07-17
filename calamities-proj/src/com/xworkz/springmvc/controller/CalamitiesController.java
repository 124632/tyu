package com.xworkz.springmvc.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.springmvc.dto.CalamitiesDTO;
import com.xworkz.springmvc.service.CalamitiesService;

@Component
@RequestMapping(value = "/")
public class CalamitiesController {
	
	@Autowired
	private CalamitiesService service;

	public CalamitiesController() {
		System.out.println("created\t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/Register.odc")
	public String message(CalamitiesDTO dto, Model model) {
		System.out.println("invoked message() method");
		System.out.println(dto);
		int i = service.createAndValidate(dto);
		if(i==0) {
			System.out.println("Sending response to success.jsp");
			model.addAttribute("dtoClass", dto);
			return "success";
		} else {
			System.out.println("sending response to index.jsp");
			model.addAttribute("valid", "Some fields are missing, so enter the details again");
			return "index";
		}

	}

}