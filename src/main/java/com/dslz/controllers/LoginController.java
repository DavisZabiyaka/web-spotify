package com.dslz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "login" /*, method = RequestMethod.POST*/)
    public String goToHomePageAfterSuccessfulLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.printf("\nUsername: %s\tPassword: %s\n", username, password);
        return "redirect:/partials/placeholder.html";
    }
}