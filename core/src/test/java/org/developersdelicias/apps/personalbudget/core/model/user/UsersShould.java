package org.developersdelicias.apps.personalbudget.core.model.user;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.developersdelicias.apps.personalbudget.core.configuration.DatabaseUnitTestConfiguration;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = DatabaseUnitTestConfiguration.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UsersShould extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private Users users;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @DatabaseSetup("/users/initial-list.xml")
    public void retrieve_all_users_in_the_database() throws Exception {
        List<User> userList = users.allUsers();
        assertThat(userList.size(), is(3));
        assertThat(userList.get(0).getFirstName(), is("Benjamin"));
    }

    @Test
    @DatabaseSetup("/users/initial-list.xml")
    @ExpectedDatabase("/users/users-after-create-new.xml")
    public void create_new_users() throws Exception {
        User newUser = new User();
        newUser.setUsername("pwalker");
        newUser.setPassword("123456");
        newUser.setFirstName("Paul");
        newUser.setLastName("Walker");
        users.add(newUser);
    }

    @Test
    @DatabaseSetup("/users/initial-list.xml")
    @ExpectedDatabase("/users/users-after-update.xml")
    public void update_a_user() throws Exception {
        System.out.println(users.allUsers());
        User benjamin = sessionFactory.getCurrentSession().load(User.class, new Long(1));
        benjamin.setLastName("Cisneros Barraza");
        System.out.println(benjamin);
        users.update(benjamin);
    }
}
