package org.developersdelicias.apps.personalbudget.core.model.user;


public class UsernameTestDataProvider {

    public Object[] validUsernames() {
        return new String[]{"bcisneros", "b123456", "benja_cisneros_", "b_e_n_j_a_m_i_n"};
    }

    public Object[] invalidUsernames() {
        return new String[]{"benja", "benjamin_cisneros_barraza", "1benja", "_benja", "Abenja", "benja@cisneros", "benja__min"};
    }
}
