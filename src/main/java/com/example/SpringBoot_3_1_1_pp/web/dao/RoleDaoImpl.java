package com.example.SpringBoot_3_1_1_pp.web.dao;

import com.example.SpringBoot_3_1_1_pp.web.model.Role;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@ToString
public class RoleDaoImpl implements RoleDao {

//    @Autowired
//    private SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String name) {
//        Role role1 = null;
//        List<Role> roleList = sessionFactory.getCurrentSession().createQuery("from Role").getResultList();
//        for(Role role : roleList){
//            if(role.getName().equals(name)){
//                role1 = role;
//            }
//        }
//        return role1;
        return (Role) entityManager.createQuery("from Role where name =:name").setParameter("name", name).getSingleResult();
    }
    public List<Role> getRoleList() {
//        List<Role> roleList = sessionFactory.getCurrentSession().createQuery("from Role").getResultList();
//        return roleList;
        return entityManager.createQuery("from Role").getResultList();
    }
}
