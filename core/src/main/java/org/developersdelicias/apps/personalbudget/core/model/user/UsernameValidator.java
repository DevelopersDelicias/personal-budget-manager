package org.developersdelicias.apps.personalbudget.core.model.user;

import java.util.regex.Pattern;

public class UsernameValidator {
    public boolean validate(String username) {
        String pattern = "^[a-z]+[a-z0-9_]{5,14}";
        boolean startsWithALowercase = Pattern.compile(pattern).matcher(username).matches();
        boolean hasConsecutiveUnderScores = Pattern.compile(".*[_]{2,}.*").matcher(username).matches();
        return startsWithALowercase  && !hasConsecutiveUnderScores;
    }
}
