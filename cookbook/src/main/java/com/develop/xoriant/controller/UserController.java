package com.develop.xoriant.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.develop.xoriant.Exceptions.UserValidationException;
import com.develop.xoriant.daos.UserDao;
import com.develop.xoriant.mapper.DynaBean;
import com.develop.xoriant.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public DynaBean getUser(@PathVariable int userId) {
		DynaBean response = new DynaBean();
		User user = userDao.getUserById(userId);
		response.set("User", user);
		if (user == null) {
			response.set("message", "User not found.");
			response.set("statusCode", HttpStatus.NOT_FOUND);
		}
		response.set("message", "User found");
		response.set("statusCode", HttpStatus.OK);

		return response;
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public DynaBean insertUser(@RequestBody User user) {
		DynaBean response = new DynaBean();
		try {
			if(user==null){
				throw new UserValidationException("Please add proper user");
			}
			else if(!isValidEmail(user.getEmailID())){
				throw new UserValidationException("Please enter valid email address");
			}
			userDao.save(user);
			response.set("message", "User created successfully.");
			response.set("statusCode", HttpStatus.CREATED);
		} catch (Exception e) {
			response.set("message", e.getMessage());
			response.set("statusCode", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping(value = "user/edit", method = RequestMethod.PUT)
	public DynaBean editUser(@RequestBody User user){
		
		DynaBean response = new DynaBean();
		try{
			userDao.updateUser(user);
			response.set("message", "User updated successfully.");
			response.set("statusCode", HttpStatus.OK);
		}catch(UserValidationException e){
			
			response.set("message", e.getMessage());
			response.set("statusCode", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                             
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
	
}
