package org.developersdelicias.apps.personalbudget.web.features.login;

import com.developersdelicias.apps.personalbudget.test.configuration.DatabaseUnitTestConfiguration;
import org.developersdelicias.apps.personalbudget.web.configuration.SpringWebConfiguration;
import org.developersdelicias.apps.personalbudget.web.configuration.SpringWebInitializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DatabaseUnitTestConfiguration.class, SpringWebConfiguration.class, SpringWebInitializer.class})
public class LoginFeatureShould {

    @Test
    public void testName() throws Exception {

    }
}