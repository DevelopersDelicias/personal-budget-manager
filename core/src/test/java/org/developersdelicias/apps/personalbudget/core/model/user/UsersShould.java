package org.developersdelicias.apps.personalbudget.core.model.user;

import com.developersdelicias.apps.personalbudget.test.configuration.DatabaseUnitTestConfiguration;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = DatabaseUnitTestConfiguration.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("/users/initial-list.xml")
public class UsersShould extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private Users users;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void retrieve_all_users_in_the_database() throws Exception {
        List<User> userList = users.allUsers();
        assertThat(userList.size(), is(3));
        assertThat(userList.get(0).getFirstName(), is("Benjamin"));
    }

    @Test
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
    @ExpectedDatabase("/users/users-after-update.xml")
    public void update_a_user() throws Exception {
        User benjamin = sessionFactory.getCurrentSession().load(User.class, new Long(1));
        benjamin.setLastName("Cisneros Barraza");
        users.update(benjamin);
    }

    @Test
    @ExpectedDatabase("/users/users-after-delete.xml")
    public void remove_a_user() throws Exception {
        users.remove(3);
    }

    @Test
    public void find_a_user_by_id() throws Exception {
        User user = users.findById(3);
        assertNotNull("A not null user is expected.", user);
        assertThat(user.getFirstName(), is("John"));
    }

    @Test(expected = UserNotFoundException.class)
    public void throw_an_exception_when_user_does_not_exists() throws Exception {
        users.findById(100);
    }

    @Test
    public void find_a_user_by_username() throws Exception {
        User user = users.findByUsername("jsmith");
        assertNotNull("A not null user is expected.", user);
        assertThat(user.getFirstName(), is("John"));
    }
}
