package org.developersdelicias.apps.personalbudget.core.model.user;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UserShould {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    @Parameters(source = UsernameTestDataProvider.class, method = "validUsernames")
    public void allow_to_set_a_valid_username(String username) {
        user.setUsername(username);
        assertThat(user.getUsername(), is(username));
    }

    @Test(expected = InvalidUsernameException.class)
    @Parameters(source = UsernameTestDataProvider.class, method = "invalidUsernames")
    public void not_allow_to_set_an_invalid_username(String username) {
        user.setUsername(username);
    }

    @Test(expected = InvalidUsernameException.class)
    public void not_allow_to_set_null_as_username() {
        user.setUsername(null);
    }

    @Test
    public void allow_to_set_a_valid_email() {
        String aValidEmail = "bcisneros@test.com";
        user.setEmail(aValidEmail);
        assertThat(user.getEmail(), is(aValidEmail));
    }

    @Test(expected = InvalidEmailException.class)
    public void not_allow_to_set_a_null_email() {
        user.setEmail(null);
    }

    @Test(expected = InvalidEmailException.class)
    public void not_allow_to_set_an_invalid_email() {
        user.setEmail("bcisneros@bcisneros@gmail.com");
    }
}
