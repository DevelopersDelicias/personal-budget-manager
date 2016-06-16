package org.developersdelicias.apps.personalbudget.core.model.user;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UsernameValidatorShould {

    private UsernameValidator validator = new UsernameValidator();

    @Test
    @Parameters({"bcisneros", "b123456", "benja_cisneros_", "b_e_n_j_a_m_i_n"})
    public void inform_when_a_username_is_valid(String username) throws Exception {
        assertThat(validator.validate(username), is(true));
    }

    @Test
    @Parameters({"benja", "benjamin_cisneros_barraza", "1benja", "_benja", "Abenja", "benja@cisneros"})
    public void inform_when_a_username_is_invalid(String username) throws Exception {
        assertThat(validator.validate(username), is(false));

    }
}
