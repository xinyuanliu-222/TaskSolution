package com.cathy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathy.service.PaliServiceImpl;

@RestController
@RequestMapping("/plain")
public class PaliController {

	@Autowired
	private final PaliServiceImpl service;
	
	public PaliController(PaliServiceImpl service) {
		this.service = service;
	}
	
	
	@GetMapping("/{input}")
	public String one(@PathVariable String input) {
		return service.getPali(input);
	}
	
}
