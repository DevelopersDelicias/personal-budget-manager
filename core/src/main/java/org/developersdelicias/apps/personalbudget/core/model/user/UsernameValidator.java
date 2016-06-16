package org.developersdelicias.apps.personalbudget.core.model.user;

import java.util.regex.Pattern;

public class UsernameValidator {
    public boolean validate(String username) {
        int length = username.length();
        boolean startsWithALowercase = Pattern.compile("^[a-z]+[a-z0-9_]*").matcher(username).matches();
        boolean hasConsecutiveUnderScores = Pattern.compile(".*[_]{2,}.*").matcher(username).matches();
        return startsWithALowercase && length >= 6 && length <= 15 && !hasConsecutiveUnderScores;
    }
}
