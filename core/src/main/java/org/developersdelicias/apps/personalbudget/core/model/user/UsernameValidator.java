package org.developersdelicias.apps.personalbudget.core.model.user;

public class UsernameValidator {
    public boolean validate(String username) {
        return username.matches("(?!.*([_])\\1)[a-z][a-z0-9_]{5,14}");
    }
}
