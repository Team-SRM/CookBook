package com.develop.xoriant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.develop.xoriant.daos.UserDaoImpl;
import com.develop.xoriant.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDaoImpl userDao;
	
	@RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public User getUser(@PathVariable int userId) {
        return userDao.getUserById(userId);
    }
}
