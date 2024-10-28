package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.models.User;
import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;

    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public User findUserByUsername(String username) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        return query.setParameter("username", username).getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.merge(user);
    }

    @Override
    public void deleteById(long id) {
        em.remove(findById(id));
    }
}