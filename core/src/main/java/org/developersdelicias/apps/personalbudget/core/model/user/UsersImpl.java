package org.developersdelicias.apps.personalbudget.core.model.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class UsersImpl implements Users {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void add(User newUser) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(newUser);
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.flush();
    }

    @Override
    public void remove(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE FROM User u WHERE u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        session.flush();
    }

    @Override
    public User findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        validate(user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("FROM User u WHERE u.username=:username")
                .setParameter("username", username)
                .list();
        validateIsNotEmpty(list);
        return list.get(0);
    }
    
    private void validateIsNotEmpty(List<User> list) {
        if (list.isEmpty()) {
            throw new UserNotFoundException();
        }
    }

    private void validate(User user) {
        if (isNull(user)) {
            throw new UserNotFoundException();
        }
    }
}
