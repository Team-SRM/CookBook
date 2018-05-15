package com.develop.xoriant.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.develop.xoriant.Exceptions.UserValidationException;
import com.develop.xoriant.model.User;

/**
 * @author Pritesh Baviskar Date: 4/26/2018
 */

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	private static final String FIND_USER_BY_EMAILID = "FROM User WHERE emailID = :emailId";

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
	public void updateUser(User user) throws UserValidationException {
		// TODO Auto-generated method stub
		User updateUser = findByEmailId(user.getEmailID());
		if(updateUser !=null){
			updateUser.setUserName(user.getUserName());
			entityManager.merge(updateUser);
			//entityManager.flush();
			
		}
		else
			throw new UserValidationException("User not found.");

	}


	@Override
	public User findByEmailId(String emailId) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(FIND_USER_BY_EMAILID);
		query.setString("emailId", emailId);
		@SuppressWarnings("unchecked")
		List<User> listOfUser = (List<User>)query.list();
		return listOfUser.get(0);
	}

}
