package org.developersdelicias.apps.personalbudget.core.model.user;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class EmailValidator {
    public boolean validate(String email) {
        return compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(email).matches();
    }
}
