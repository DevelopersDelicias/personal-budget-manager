package org.developersdelicias.apps.personalbudget.core.model.user;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.developersdelicias.apps.personalbudget.core.model.user.validators.EmailValidator;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(JUnitParamsRunner.class)
public class EmailValidatorShould {

    final EmailValidator validator = new EmailValidator();

    @Test
    @Parameters({"bcisneros@yahoo.com", "bcisneros-100@yahoo.com", "bcisneros.100@yahoo.com", "bcisneros111@bcisneros.com",
            "bcisneros-100@bcisneros.net", "bcisneros.100@bcisneros.com.au", "bcisneros@1.com", "bcisneros@gmail.com.com",
            "bcisneros+100@gmail.com", "bcisneros-100@yahoo-test.com"})
    public void inform_when_email_is_valid(String email) {
        assertThat(validator.validate(email), is(true));
    }

    @Test
    @Parameters({"bcisneros", "bcisneros@.com.my", "bcisneros123@gmail.a", "bcisneros123@.com", "bcisneros123@.com.com",
            ".bcisneros@bcisneros.com", "bcisneros()*@gmail.com", "bcisneros@%*.com", "bcisneros..2002@gmail.com",
            "bcisneros.@gmail.com", "bcisneros@bcisneros@gmail.com", "bcisneros@gmail.com.1a"})
    public void inform_when_email_is_invalid(String email) {
        assertThat(validator.validate(email), is(false));
    }
}
