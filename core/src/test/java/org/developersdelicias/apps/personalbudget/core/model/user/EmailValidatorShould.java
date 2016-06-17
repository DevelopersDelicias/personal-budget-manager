package org.developersdelicias.apps.personalbudget.core.model.user;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(JUnitParamsRunner.class)
public class EmailValidatorShould {

    @Test
    @Parameters({"bcisneros@yahoo.com", "bcisneros-100@yahoo.com", "bcisneros.100@yahoo.com", "bcisneros111@bcisneros.com",
            "bcisneros-100@bcisneros.net", "bcisneros.100@bcisneros.com.au", "bcisneros@1.com", "bcisneros@gmail.com.com",
            "bcisneros+100@gmail.com", "bcisneros-100@yahoo-test.com"})
    public void inform_when_email_is_valid(String email) throws Exception {
       EmailValidator validator = new EmailValidator();
        assertThat(validator.validate(email), is(true));
    }
}
