package com.develop.xoriant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.develop.xoriant.daos.DishDao;
import com.develop.xoriant.mapper.DynaBean;
import com.develop.xoriant.model.Dish;

@RestController
public class DishController {

	@Autowired
	private DishDao dishDao;
	
	@RequestMapping(value = "/dish/add", method = RequestMethod.POST)
	public DynaBean insertDish(@RequestBody Dish dish) {
		DynaBean response = new DynaBean();
		try {
			dishDao.addDish(dish);
			response.set("message", "Dish added successfully.");
			response.set("statusCode", HttpStatus.CREATED);
		} catch (Exception e) {
			response.set("message", e.getMessage());
			response.set("statusCode", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
