package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.models.Role;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private final EntityManager em;

    public RoleDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Role findRoleByName(String roleName) {
        TypedQuery<Role> query = em.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class);
        return query.setParameter("name", roleName).getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        return em.createQuery("from Role").getResultList();
    }
}