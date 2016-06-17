package org.developersdelicias.apps.personalbudget.web.features.login;

import com.developersdelicias.apps.personalbudget.test.configuration.DatabaseUnitTestConfiguration;
import com.gargoylesoftware.htmlunit.WebClient;
import org.developersdelicias.apps.personalbudget.web.configuration.SpringWebConfiguration;
import org.developersdelicias.apps.personalbudget.web.configuration.SpringWebInitializer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DatabaseUnitTestConfiguration.class, SpringWebConfiguration.class, SpringWebInitializer.class})
public abstract class AbstractFeature {

    public static final String CONTEXT_PATH = "/personal-budget-manager";
    public static String BASE_URL = "http://localhost" + CONTEXT_PATH;

    @Autowired
    protected WebApplicationContext context;
    protected WebClient client;


    public void setup() throws Exception {
        client = webAppContextSetup(context).contextPath(CONTEXT_PATH).createWebClient();
        client.getOptions().setJavaScriptEnabled(false);
    }

    protected String urlFor(String path) {
        return BASE_URL + path;
    }
}
