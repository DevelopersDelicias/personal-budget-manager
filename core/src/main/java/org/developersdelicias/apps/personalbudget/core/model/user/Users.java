package org.developersdelicias.apps.personalbudget.core.model.user;


import java.util.List;

public interface Users {
    List<User> allUsers();

    void add(User newUser);

    void update(User user);

    void remove(long id);

    User findById(long id);

    User findByUsername(String username);
}
