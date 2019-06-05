package com.dslz.controllers;

import com.dslz.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    /**
     * API that fetches the login view
     * @return login view (login.html)
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    /**
     * API that returns a login error for the login view
     * @param model userd for adding login-error attribute
     * @return login view (login.html)
     */
    /*
    @RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
    }
    */

    /**
     * API that fetches the registration view
     * @return registration view (register.html)
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String goToRegistrationPage() {
        return "register";
    }

    /**
     * API that fetches the home view
     * at which point is the angularjs portion of the application
     * @return home view (#/home)
     * 
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String goToHomePage() {
        return "/";
    }

}