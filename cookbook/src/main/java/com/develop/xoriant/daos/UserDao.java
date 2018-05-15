package com.develop.xoriant.daos;

import com.develop.xoriant.Exceptions.UserValidationException;
import com.develop.xoriant.model.User;

/**
 * @author Pritesh Baviskar
 * Date: 4/26/2018
 */
public interface UserDao {

	User getUserById(int userId);
	User findByEmailId(String emailId);
    void save(User user);
    void updateUser(User user)throws UserValidationException;
}
