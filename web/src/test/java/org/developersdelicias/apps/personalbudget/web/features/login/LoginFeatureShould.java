package org.developersdelicias.apps.personalbudget.web.features.login;

import com.developersdelicias.apps.personalbudget.test.configuration.DatabaseUnitTestConfiguration;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.developersdelicias.apps.personalbudget.web.configuration.SpringWebConfiguration;
import org.developersdelicias.apps.personalbudget.web.configuration.SpringWebInitializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DatabaseUnitTestConfiguration.class, SpringWebConfiguration.class, SpringWebInitializer.class})
public class LoginFeatureShould {

    @Autowired
    WebApplicationContext context;

    WebClient client;
    HtmlPage homePage;

    @Before
    public void setup() throws Exception {
        MockMvcWebClientBuilder mockMvcWebClientBuilder = MockMvcWebClientBuilder.webAppContextSetup(context);
        MockMvcWebClientBuilder mockMvcWebClientBuilder1 = mockMvcWebClientBuilder.contextPath("/personal-budget-manager");
        client = mockMvcWebClientBuilder1.createWebClient();
        client.getOptions().setJavaScriptEnabled(false);
        //homePage = client.getPage("http://localhost/personal-budget-manager/");
    }

    @Test
    public void testName() throws Exception {

    }
}
