package me.dio.web.parking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InitialController {

	@RequestMapping(value = "/")
	public ModelAndView getMessage() {	
		return new ModelAndView("swagger-ui.html");
	}
}
