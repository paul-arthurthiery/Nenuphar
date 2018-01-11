package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.Models.LDAP;
import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Services.LDAPService;
import com.nenuphar.nenufar.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private LDAPService ldapService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    private ResponseEntity getUserById(@PathVariable("id") long id){
        User user = userService.getUser(id);
        if(user==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody String name, String lastName, String email, String login, String password, boolean isRespoAPP, boolean isAdmin, boolean isTutor, boolean isStudent)
    {
        User user = userService.createUser(name, lastName, email, login, password, isRespoAPP, isAdmin, isTutor, isStudent);
        if(user==null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody String login, String password)
    {

        LDAP ldap;
        try
        {
            ldap = ldapService.LDAPget(login, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(ldap==null){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

        return new ResponseEntity<>(ldap, HttpStatus.OK);
    }

    @RequestMapping(value = "/test/", method = RequestMethod.POST)
    public ResponseEntity test(@RequestBody String login, String password)
    {
        if(login == "test")
        {
            return new ResponseEntity<>("le login", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("login : "+login+" / "+"password : "+password, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/test/{login}", method = RequestMethod.GET)
    private ResponseEntity getUserByLogin(@PathVariable("login") String login)
    {
        User user = userService.getUserByLogin(login);
        if(user==null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
