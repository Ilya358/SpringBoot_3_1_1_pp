package com.example.SpringBoot_3_1_1_pp.web.dao;

import com.example.SpringBoot_3_1_1_pp.web.model.User;
import com.example.SpringBoot_3_1_1_pp.web.service.RoleService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@ToString
public class UserDaoImpl implements UserDao {

//    @Autowired
//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoleService roleService;

    @Override
    public void add(User user) {
//        user.setRoles(getSetRole(user));
//        sessionFactory.getCurrentSession().save(user);
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
//        return sessionFactory.getCurrentSession().get(User.class, id);
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void updateUser(User user) {
//        sessionFactory.getCurrentSession().update(user);
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
//        User user = sessionFactory.getCurrentSession().load(User.class, id);
//        sessionFactory.getCurrentSession().delete(user);
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserByName(String name) {
//        User user = null;
//        Query query = sessionFactory.getCurrentSession().createQuery("from User where name = :name");
//        query.setParameter("name", name);
//        user = (User) query.getSingleResult();
//        return user;
        return (User) entityManager.createQuery("from User where name =:name").setParameter("name", name).getSingleResult();
    }
}
