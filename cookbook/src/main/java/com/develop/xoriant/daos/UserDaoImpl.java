package com.develop.xoriant.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.develop.xoriant.model.User;

/**
 * @author Pritesh Baviskar
 * Date: 4/26/2018
 */

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext 
	private EntityManager entityManager;	

	@Override
	public User getUserById(int userId) {
			// TODO Auto-generated method stub
		return entityManager.find(User.class, userId);
	} 
	
    @Override
    public void save(User user) {
    	entityManager.persist(user);

    }

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		User updateUser = getUserById(user.getUserID());
		updateUser.setUserName(user.getUserName());
		updateUser.setEmailID(user.getEmailID());
		entityManager.flush();
		
	} 
    
}
