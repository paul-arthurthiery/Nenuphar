package com.nenuphar.nenufar.Controllers;

import com.nenuphar.nenufar.DTO.GetIDDTO;
import com.nenuphar.nenufar.DTO.GettokenDTO;
import com.nenuphar.nenufar.DTO.LoginAttemptDTO;
import com.nenuphar.nenufar.Models.LDAP;
import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Services.LDAPService;
import com.nenuphar.nenufar.Services.UserService;
import com.nenuphar.nenufar.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LDAPService ldapService;

    @RequestMapping(value = "/get_teammates", method = RequestMethod.POST)
    private ResponseEntity getTeamMatesFromUUID(@RequestBody GettokenDTO dto)
    {
        String uuid = dto.getToken();
        List<User> teammates = userService.getTeamMatesFromUUID(uuid);
        if(teammates==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(teammates, HttpStatus.OK);
    }

    @RequestMapping(value = "/get_workgroup_members", method = RequestMethod.POST)
    private ResponseEntity getWorkgroupMembersFromUUID(@RequestBody GettokenDTO dto)
    {
        String uuid = dto.getToken();
        List<User> workgroup_members = userService.getWorkgroupMembersFromUUID(uuid);
        if(workgroup_members==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(workgroup_members, HttpStatus.OK);
    }

    @RequestMapping(value = "/get_user", method = RequestMethod.POST)
    private ResponseEntity getUserById(@RequestBody GetIDDTO dto){
        Long id = dto.getID();
        User user = userService.getUser(id);
        if(user==null) {return new ResponseEntity(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody String name, String lastName, String email, String login, String password, boolean isRespoAPP, boolean isAdmin, boolean isTutor, boolean isStudent)
    {
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        User user = userService.createUser(name, lastName, email, login, encodedPassword, isRespoAPP, isAdmin, isTutor, isStudent);
        if (user==null) {return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginAttemptDTO dto)
    {
        String login = dto.getLogin();
        String password = dto.getPassword();
        User user = userService.getUserByLogin(login);

        if (user != null) {
            // USER FOUND IN THE DATABASE

            String valid_password = user.getPassword();
            BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();


            // user is authenticated
            // TODO perform authentication logic here
            String uuid = UUID.randomUUID().toString();
            userService.generateUUID(user, uuid);
            return new ResponseEntity<>(uuid, HttpStatus.OK);
        }

        // user not found in database :

        // HERE MAKE LDAP CHECK
        // TODO LDAP STUFF NOT WORKING YET
        LDAP person = null;
        try {
            person = ldapService.LDAPget(login, password);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (person == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        // Create the user in database :
        String p_nom = person.getNom();
        String p_nomFamille = person.getNomFamille();
        String p_prenom = person.getPrenom();
        String p_employeeType = person.getType();
        String p_employeeNumber = person.getNumber();
        String p_login = person.getLogin();
        String p_password = person.getPassword();
        String p_mail = person.getMail();
        boolean isTutor = false;
        boolean isStudent = false;

        if (("teacher").equals(p_employeeType)) isTutor = true;
        else if (("student").equals(p_employeeType)) isStudent = true;

        String encodedPassword = new BCryptPasswordEncoder().encode(p_password);

        User new_user = userService.createUser(p_prenom, p_nomFamille, p_mail, p_login, encodedPassword,false,false, isTutor, isStudent);
        String uuid = UUID.randomUUID().toString();
        userService.generateUUID(new_user, uuid);
        return new ResponseEntity<>(uuid, HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity test(@RequestBody LoginAttemptDTO dto)
    {
        String login = dto.getLogin();
        String password = dto.getPassword();
        String uuid = UUID.randomUUID().toString();

        if(("test").equals(login)) {
            return new ResponseEntity<>("le uuid "+uuid , HttpStatus.OK);
        } else {
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

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    private User authenticateWithUUID(@RequestBody GettokenDTO dto) {
        String uuid = dto.getToken();
        //return new ResponseEntity<>(uuid, HttpStatus.OK);
        User user = userService.getUserByUUID(uuid);
        
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        
        return user;
    }

    @RequestMapping(value = "/ldap", method = RequestMethod.POST)
    public ResponseEntity ldap(@RequestBody LoginAttemptDTO dto)
    {
        String login = dto.getLogin();
        String password = dto.getPassword();
        //return new ResponseEntity<>("login: "+login+" / password : "+password, HttpStatus.OK);
        LDAP person = null;
        try
        {
            person = ldapService.LDAPget(login, password);
        } catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>("erreur",HttpStatus.BAD_REQUEST);
        }


        if (person == null) {return new ResponseEntity<>("y'a personne",HttpStatus.BAD_REQUEST);}

        return new ResponseEntity<>("prenom : "+person.getPrenom()+" / "+"nom : "+person.getNom(), HttpStatus.OK);
    }
}
