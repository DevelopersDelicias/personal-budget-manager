package org.developersdelicias.apps.personalbudget.web.features.login;

import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class LoginFeatureShould extends AbstractFeature {

    private HtmlPage homePage;

    @Before
    @Override
    public void setup() throws Exception {
        super.setup();
        homePage = client.getPage(urlFor("/"));
    }

    @Test
    public void get_status_ok_when_home_page_is_requested() {
        assertThat(homePage.getWebResponse().getStatusCode(), is(200));
    }

    @Test
    public void have_a_title() {
        assertThat(homePage.getTitleText(), is("Personal Budget Manager"));
    }

    @Test
    public void have_an_email_input() throws Exception {
        HtmlInput emailInput = homePage.getFirstByXPath("//input[@type='email']");
        assertNotNull(emailInput);
    }
}
