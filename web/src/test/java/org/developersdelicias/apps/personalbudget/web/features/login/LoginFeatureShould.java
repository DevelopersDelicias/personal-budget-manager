package org.developersdelicias.apps.personalbudget.web.features.login;

import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class LoginFeatureShould extends AbstractFeature {

    private HtmlPage loginPage;

    @Before
    @Override
    public void setup() throws Exception {
        super.setup();
        loginPage = client.getPage(urlFor("/"));
    }

    @Test
    public void get_status_ok_when_home_page_is_requested() {
        assertThat(loginPage.getWebResponse().getStatusCode(), is(200));
    }

    @Test
    public void have_a_body_id() {
        assertThat(loginPage.getBody().getId(), is("login-page"));
    }

    @Test
    public void have_a_title() {
        assertThat(loginPage.getTitleText(), is("Personal Budget Manager"));
    }

    @Test
    public void have_an_email_input() {
        assertNotNull(getFirstInputElementOfType("email"));
    }

    @Test
    public void have_a_password_input() {
        assertNotNull(getFirstInputElementOfType("password"));
    }

    @Test
    public void submit_login_form_and_retrieve_an_html_page() throws Exception {
        HtmlPage homepage = submitLoginForm("bcineros@test.com", "123456");
        assertThat(homepage.getWebResponse().getStatusCode(), is(200));
        assertThat(homepage.getBody().getId(), is("homepage"));

    }

    private HtmlPage submitLoginForm(String email, String password) throws java.io.IOException {
        final HtmlForm loginForm = loginPage.getFormByName("login-form");
        assertNotNull(loginForm);
        final HtmlSubmitInput submitButton = loginForm.getInputByName("submit");
        assertNotNull(submitButton);
        HtmlTextInput emailInput = loginForm.getInputByName("email");
        HtmlPasswordInput passwordInput = loginForm.getInputByName("password");
        emailInput.setValueAttribute(email);
        passwordInput.setValueAttribute(password);
        return submitButton.click();
    }

    private HtmlInput getFirstInputElementOfType(String type) {
        return loginPage.getFirstByXPath("//input[@type='" + type + "']");
    }
}
