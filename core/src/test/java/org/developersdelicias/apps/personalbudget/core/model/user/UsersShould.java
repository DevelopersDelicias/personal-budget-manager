package org.developersdelicias.apps.personalbudget.core.model.user;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.developersdelicias.apps.personalbudget.core.configuration.DatabaseUnitTestConfiguration;
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

    @Test
    @DatabaseSetup("/users/initial-list.xml")
    public void retrieve_all_users_in_the_database() {
        List<User> userList = users.allUsers();
        assertThat(userList.size(), is(3));
        assertThat(userList.get(0).getFirstName(), is("Benjamin"));
    }
}
