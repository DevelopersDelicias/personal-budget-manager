package org.developersdelicias.apps.personalbudget.web.features.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

    @RequestMapping(value = {"/"}, method = GET, name = "homepage")
    public String index() {
        return "login.html";
    }

    @RequestMapping(value = {"/submit-login"}, method = POST, name = "login")
    public String login() {
        return "homepage.html";
    }
}
