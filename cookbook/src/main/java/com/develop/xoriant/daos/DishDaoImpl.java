package com.develop.xoriant.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.develop.xoriant.model.Dish;

@Transactional
@Repository
public class DishDaoImpl implements DishDao{

	@PersistenceContext
	private EntityManager entityManager;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void addDish(Dish dish) {
		// TODO Auto-generated method stub
		/*SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("insert into dish(name) values(:dishName)");
		query.setParameter("dishName", dish.getDishName());
		query.executeUpdate();*/
		entityManager.persist(dish);
	}
}
