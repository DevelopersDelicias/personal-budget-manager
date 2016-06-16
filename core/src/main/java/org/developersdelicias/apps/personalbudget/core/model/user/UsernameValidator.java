package org.developersdelicias.apps.personalbudget.core.model.user;

import static java.util.Objects.isNull;

class UsernameValidator {
    boolean validate(String username) {
        return !isNull(username) && username.matches("(?!.*([_])\\1)[a-z][a-z0-9_]{5,14}");
    }
}
