package com.dslz.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.validation.Valid;

import com.dslz.beans.User;
import com.dslz.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "login" /* , method = RequestMethod.POST */)
    public String goToHomePageAfterSuccessfulLogin(@RequestParam("username") String username,
            @RequestParam("password") String password) {
        // System.out.printf("\nUsername: %s\tPassword: %s\n", username, password);
        // return "redirect:/partials/placeholder.html";
        return "Great!";
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
/*
    @RequestMapping(value = "user/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> createUser(@Valid @RequestBody User createdUser) {
        List<User> users = userService.findAllUsers();
        for (User user : users) {
            if (user.getUserEmail().equals(createdUser.getUserEmail())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            createdUser.set
        }
    }
*/

    @RequestMapping(value = "user/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> createUser(String userEmail, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        List<User> users = userService.findAllUsers();
        userEmail = "johndoe@gmail.com";
        password = "admin123";
        for (User user : users) {
            if (user.getUserEmail().equals(userEmail)) {
                // System.out.println("User already exists!");
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        byte[] salt = generateSalt();
        byte[] encryptedPassword = getEncryptPassword(password, salt);
        User newUser = new User(userEmail, encryptedPassword, salt);
        // System.out.println(newUser);
        userService.createUser(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public byte[] getEncryptPassword(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
        // specifically names SHA-1 as an acceptable hashing algorithm for PBKDF2
        String algorithm = "PBKDF2WithHmacSHA1";
        // SHA-1 generates 160 bit hashes, so that's what makes sense here
        int derivedKeyLength = 160;
        // Pick an iteration count that works for you. The NIST recommends at
        // least 1,000 iterations:
        // http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
        // iOS 4.x reportedly uses 10,000:
        // http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/
        int iterations = 10_000;

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);

        return secretKeyFactory.generateSecret(spec).getEncoded();
    }

    public byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

        // Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
        byte[] salt = new byte[8];
        secureRandom.nextBytes(salt);

        return salt;
    }
}