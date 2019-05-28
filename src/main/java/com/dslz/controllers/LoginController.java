package com.dslz.controllers;

import java.util.List;

import com.dslz.beans.User;
import com.dslz.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "login" /*, method = RequestMethod.POST*/)
    public String goToHomePageAfterSuccessfulLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.printf("\nUsername: %s\tPassword: %s\n", username, password);
        return "redirect:/partials/placeholder.html";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = (List<User>) userService.findAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users currently in the database");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (User user : users) {
            System.out.println(user);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}