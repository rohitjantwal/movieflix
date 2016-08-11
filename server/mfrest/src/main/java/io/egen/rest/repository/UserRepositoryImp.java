package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.User;

@Repository
@Transactional
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findByUserId(String id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByEmailId(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmailId", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}
	//persist is insert into
	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}
    //merge is update
	@Override
	public User update(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void delete(User user) {
		em.remove(user);
		
	}

}
