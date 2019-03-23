package org.transfer.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.transfer.service.dao.AccountDao;
import org.transfer.service.dao.UserDao;
import org.transfer.service.entity.Account;
import org.transfer.service.entity.User;
import org.transfer.service.services.UserService;
import org.transfer.service.services.exception.UserServiceException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest controller for handling all the operations related to user
 * it can be used to create and fetch the user details
 *
 * @author Vibha
 * @version : 1.0.0
 *
 *	REST URLS:
 *
 *	 *   POST : /createAccount -> to create user and account
 *
 *
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountDao accountdio;
    @Autowired
    private UserDao userdio;


    /**
     * This method is used to create a new user
     *
     * @param user input details of user
     * @return the newly created user Details
     */
    @RequestMapping(value = "createAccount",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public User createUser(@Valid @RequestBody User user) {
        User userObj = null;
        try {
             userObj = userService.createUser(user);
        } catch (UserServiceException e) {
            e.printStackTrace();
        }
        return userObj;
    }

    @RequestMapping("/hello")
    public String sayHi(){
        return "Hello";

    }

    @RequestMapping(value = "displayaccounts",
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Account> createUser() {
        List<Account> accounts = new ArrayList<>();
          return accountdio.findAll();
    //    accountdio.findAll().forEach(accounts::add);
    //    return accounts;
    }

    @RequestMapping(value = "displayusers",
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public List<User> createUser1() {
        List<User> accounts = new ArrayList<>();
        userdio.findAll().forEach(accounts::add);
        return accounts;
    }



}

