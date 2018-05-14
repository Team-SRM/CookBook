package com.develop.xoriant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pritesh Baviskar Date: 4/25/2018
 */

@RestController
public class BaseController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Hello lalala!";
	}
}
