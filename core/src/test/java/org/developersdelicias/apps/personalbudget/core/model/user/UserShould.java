package org.developersdelicias.apps.personalbudget.core.model.user;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UserShould {

    @Test
    @Parameters({"bcisneros", "b123456", "benja_cisneros_", "b_e_n_j_a_m_i_n"})
    public void allow_to_set_a_valid_username(String username) throws Exception {
        User user = new User();
        user.setUsername(username);
        assertThat(user.getUsername(), is(username));
    }

    @Test(expected = InvalidUsernameException.class)
    @Parameters({"benja", "benjamin_cisneros_barraza", "1benja", "_benja", "Abenja", "benja@cisneros", "benja__min"})
    public void not_allow_to_set_an_invalid_username(String username) throws Exception {
        User user = new User();
        user.setUsername(username);
    }
}
