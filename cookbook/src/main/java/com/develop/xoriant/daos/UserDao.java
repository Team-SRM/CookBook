package com.develop.xoriant.daos;

import com.develop.xoriant.model.User;

/**
 * @author Pritesh Baviskar
 * Date: 4/26/2018
 */
public interface UserDao {

	User getUserById(int userId);
    void save(User user);
    void updateUser(User user);
}
